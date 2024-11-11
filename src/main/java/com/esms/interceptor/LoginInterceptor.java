package com.esms.interceptor;

import com.esms.po.SystemManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：1:34 2019/10/13
 * @Version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String requestUri = httpServletRequest.getRequestURI();
//        String contextPath = httpServletRequest.getContextPath();
//        String url = requestUri.substring(contextPath.length());
//        System.out.println(url);
//        System.out.println(requestUri);
//        if ("/".equals(url)){
//            return true;
//        }
//        if ("/employeeLogin.do".equals(url)){
//            return true;
//        }else{
        String string = (String) httpServletRequest.getSession().getAttribute("employeeId");
        SystemManager systemManager = (SystemManager) httpServletRequest.getSession().getAttribute("admin");
        if (string != null) {
            return true;
        } else if (string == null){
            httpServletResponse.sendRedirect("/");
            return false;
        } else if (systemManager != null) {
            return true;
        } else {
            httpServletResponse.sendRedirect("/admin.do");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
