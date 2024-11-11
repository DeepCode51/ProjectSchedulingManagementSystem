package com.esms.controller;

import com.esms.exception.CustomException;
import com.esms.po.Employee;
import com.esms.po.SystemManager;
import com.esms.service.impl.LoginServiceImpl;
import com.esms.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: admin
 * @Description: 管理员和员工登陆控制
 * @Date: 14:33 2019/10/5
 **/
@Controller
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService = null;
    /**
     * @Author: admin
     * @Description:
     * @Date: 14:33 2019/10/5
     * @Param: [request, response]
     * @Return: void
     **/
    @RequestMapping(value = "/changeCode.do")
    @ResponseBody
    public void getIdentifyingCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 验证码存储在session的identifyingCode，属性中
        CaptchaUtil.outputCaptcha(request, response);
    }

    // 获取员工登陆界面
    @RequestMapping("/")
    public String getLoginPage(){
        return "employee/login.html";
    }

    // 获取管理员登陆界面
    @RequestMapping("/admin.do")
    public String getAdminLoginPage(){
        return "admin/adminLogin.html";
    }

    @RequestMapping(value = "/employeeLogin.do")
    @ResponseBody
    public Map<String,String> employeeLogin(Model model, HttpSession httpSession, String username,
                             String password, String identifyingcode)
    {
        String code = (String) httpSession.getAttribute("identifyingCode");
        HashMap<String, String> map = new HashMap<String, String>();
        if(identifyingcode.equalsIgnoreCase(code)){
            Employee employee = null;
            try {
                employee = loginService.findEmployeeByIdAndPassword(username, password);
            } catch (CustomException e) {
                map.put("msg",e.getMessage());
                map.put("status","500");
                return map;
            }
            // 保存到session
            httpSession.setAttribute("employeeId",employee.geteId());
            map.put("url","/ssm_esms/loginSuccess.do");
            map.put("msg","成功");
            map.put("status","200");
            return map;
        }else{
            map.put("msg","验证码错误");
            map.put("status","0");
            return map;
        }
    }

    @RequestMapping(value = "/loginSuccess.do")
    public String loginSucceses(Model model) throws Exception
    {
        return "employee/index.html";
    }

    @RequestMapping(value = "/adminLogin.do")
    @ResponseBody
    public Map<String,String> adminLogin(Model model, HttpSession httpSession, String username,
                                            String password, String identifyingcode)
    {
        String code = (String) httpSession.getAttribute("identifyingCode");
        HashMap<String, String> map = new HashMap<String, String>();
        if(identifyingcode.equalsIgnoreCase(code)){
            SystemManager manager = null;
            try {
                 manager = loginService.findSystemManagerByIdAndPassword(username, password);
            } catch (CustomException e) {
                map.put("msg",e.getMessage());
                map.put("status","500");
                return map;
            }
            // 保存到session
            httpSession.setAttribute("admin",manager);
            map.put("url","toPage.do?url=admin/index.html");
            map.put("msg","成功");
            map.put("status","200");
            return map;
        }else{
            map.put("msg","验证码错误");
            map.put("status","0");
            return map;
        }
    }
    @RequestMapping(value = "/getAdminAccount.do")
    @ResponseBody
    public String getAdminAccount(HttpSession httpSession){
        SystemManager systemManager = (SystemManager) httpSession.getAttribute("admin");
//        SystemManager manager = loginService.findSystemManagerById(id);
        return systemManager.getSmAccount();
    }

    @RequestMapping(value = "/getEmployeeAccount.do")
    @ResponseBody
    public Map<String,String> getEmployeeAccount(HttpSession httpSession){
        Integer id = (Integer) httpSession.getAttribute("employeeId");
        Employee employee = loginService.findEmployeeById(id);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("account",employee.geteAccount());
        map.put("name",employee.geteName());
        return map;
    }
    @RequestMapping(value = "/logout.do")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("employeeId");
        return "redirect:/";
    }

    @RequestMapping(value = "/logoutAdmin.do")
    public String logoutAdmin(HttpSession httpSession){
       httpSession.removeAttribute("admin");
       return "redirect:/admin.do";
    }
}
