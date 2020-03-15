package com.wugz.sss.controller.login.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginInterceptor
 * @Description 拦截器 验证是否登录
 * @Author wugz
 * @Date 2020/3/14 18:30
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * @Description: 验证登录session 中是否有username字段 若不存在则返回到登录页面
     * @param request
     * @param response
     * @param obj
     * @Date: 2020/3/14 18:31
     * @Author: wuguizhen
     * @Return boolean
     * @Throws
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        //判断session中的数据,得知是否登录表
        HttpSession session=request.getSession();
        if(session.getAttribute("username")==null){
            System.out.println("用户未登录 跳转登录页面");
            response.sendRedirect("/login");
            //返回false拦截
            return false;
        }
        //返回true不拦截
        return true;
    }
}
