package com.kj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        // 把用户信息存在session中
        session.setAttribute("loginInfo",username);
        if (username.equals("admin")&&password.equals("123")){
            return "redirect:/book/allBook";
        }else{
            model.addAttribute("FailLogin","登录失败！");
        }
        return "redirect:/index.jsp";  // 跳转首页的方法
    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpSession session, HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        // 把用户信息存在session中
        session.removeAttribute("loginInfo");
        resp.sendRedirect("http://localhost:8080/");  // 使用绝对路径
    }
}
