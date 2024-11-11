package com.esms.controller;

import com.esms.exception.CustomException;
import com.esms.po.Employee;
import com.esms.po.Salary;
import com.esms.po.SystemManager;
import com.esms.service.impl.UserInforServiceImpl;
import com.esms.utils.MD5Utils;
import com.esms.vo.EmployeeCustomVo;
import com.esms.vo.EmployeeSalaryVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：20:31 2019/10/6
 * @Version: 1.0
 */
@Controller
public class UserInforController {
    @Autowired
    private UserInforServiceImpl userInforService = null;

    @RequestMapping("changePassword.do")
    @ResponseBody
    public Map<String, String> changePassword(String oldPassword, String newPassword1,
                                              String newPassword2, HttpSession httpSession){
        System.out.println(oldPassword+" "+newPassword1+" "+newPassword2);
        HashMap<String, String> map = new HashMap<String, String>();
        if (newPassword1.equals(newPassword2)){
            SystemManager admin = (SystemManager) httpSession.getAttribute("admin");
            String encodeByMD5 = MD5Utils.encodeByMD5(oldPassword);
            if (encodeByMD5.equals(admin.getSmPassword())){
                String newPassword = MD5Utils.encodeByMD5(newPassword1);
                admin.setSmPassword(newPassword);
                userInforService.updateSystemManagePassword(admin.getSmId(),admin);
                map.put("status","1");
                map.put("msg","密码修改成功");
                return map;
            }else{
                map.put("status","2");
                map.put("msg","原密码错误");
                return map;
            }
        }else{
            map.put("status","0");
            map.put("msg","两次密码不一致");
            return map;
        }
    }
    @RequestMapping("changeEmployeePassword.do")
    @ResponseBody
    public Map<String, String> changeEmployeePassword(String oldPassword, String newPassword1,
                                              String newPassword2, HttpSession httpSession){
        System.out.println(oldPassword+" "+newPassword1+" "+newPassword2);
        HashMap<String, String> map = new HashMap<String, String>();
        if (newPassword1.equals(newPassword2)){
            Integer eid = (Integer) httpSession.getAttribute("employeeId");
            try {
                userInforService.updateEmployeePassword(eid, oldPassword, newPassword1);
                map.put("status","1");
                map.put("msg","密码修改成功");
                return map;
            } catch (CustomException e) {
                map.put("status","2");
                map.put("msg","原密码错误");
                return map;
            }
        }else{
            map.put("status","0");
            map.put("msg","两次密码不一致");
            return map;
        }
    }

    @RequestMapping("inforEmployee.do")
    public @ResponseBody EmployeeCustomVo getInforEmployee(HttpSession httpSession){
        Integer id = (Integer) httpSession.getAttribute("employeeId");
        EmployeeCustomVo employeeCustomVo = userInforService.getInforEmployee(id);
        return employeeCustomVo;
    }

    @RequestMapping("updateInforEmployee.do")
    public @ResponseBody String updateInforEmployee(HttpSession httpSession, Employee employee){
        Integer id = (Integer) httpSession.getAttribute("employeeId");
        employee.seteId(id);
        int i = userInforService.updateEmploueeById(id,employee);
        if (i==1){
            return "1";
        }else {
            return "0";
        }
    }

//    @RequestMapping("employeeSalaryList.do")
//    @ResponseBody
//    public EmployeeSalaryVO employeeSalaryList(@RequestParam(name="year",defaultValue = "1") String year,
//                                           HttpSession httpSession){
//        Integer eId = (Integer) httpSession.getAttribute("employeeId");
//        List<Salary> salaryList = userInforService.getEmployeeSalaryList(eId, year);
//
//        EmployeeSalaryVO employeeSalaryVO = new EmployeeSalaryVO();
//        employeeSalaryVO.setCode(0);
//        employeeSalaryVO.setMsg("");
//        employeeSalaryVO.setCount((int) salaryList.size());
//        employeeSalaryVO.setData(salaryList);
//        return employeeSalaryVO;
//    }


    @RequestMapping("employeeSalaryList.do")
    @ResponseBody
    public EmployeeSalaryVO findSelective(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="10") int limit,
            @RequestParam(value="year", defaultValue="1") String year,
            HttpSession httpSession) throws Exception {

        Integer eId = (Integer) httpSession.getAttribute("employeeId");
        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        List<Salary> salaryList = userInforService.getEmployeeSalaryList(eId, year);

        PageInfo pageResult = new PageInfo(salaryList);

        //设置前台需要的数据
        EmployeeSalaryVO employeeSalaryVO = new EmployeeSalaryVO();
        employeeSalaryVO.setCode(0);
        employeeSalaryVO.setMsg("");
        employeeSalaryVO.setCount((int) pageResult.getTotal());
        employeeSalaryVO.setData(pageResult.getList());
        return employeeSalaryVO;
    }

}
