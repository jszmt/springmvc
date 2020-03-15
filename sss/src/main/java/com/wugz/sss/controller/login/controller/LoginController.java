package com.wugz.sss.controller.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description
 * @Author wugz
 * @Date 2020/3/14 18:37
 * @Version 1.0
 */
@RequestMapping("/")
@Controller
public class LoginController {
    
    /** 默认用户名 */
    private static final String DEFAULT_USERNAME = "admin";
    /** 默认密码 */
    private static final String DEFAULT_PASSWORD = "admin"; 

    @RequestMapping("/")
    public String index(){
        return "/index";
    }


    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        /** 如果用户名密码不正确 就返回登录页面 */
        if(!DEFAULT_PASSWORD.equals(password) || !DEFAULT_USERNAME.equals(username)){
            System.out.println("用户名 " + username + " 或密码 " + password + " 不正确");
            return "index";
        }
        /** 验证登录成功后 将用户名放到session中 */
        request.getSession().setAttribute("username",username);
        /** 跳转到列表页面 */
        return "redirect:/resumer/";
    }



}
