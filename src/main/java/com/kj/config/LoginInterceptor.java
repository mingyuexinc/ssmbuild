package com.kj.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    // false:拦截    true:放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在登录页面，放行
        if (request.getRequestURI().contains("login")){
            return true;
        }
        // 判断什么情况下放行
        HttpSession session = request.getSession();
        if (session.getAttribute("loginInfo")!=null){
            return true;
        }
        // 判断什么情况下没有登录
        response.sendRedirect("http://localhost:8080/");  // 使用绝对路径
        return false;
    }
}
