package com.wugz.mvc.mvcframework.demo.controller;


import com.wugz.mvc.mvcframework.annotations.LagouAutowired;
import com.wugz.mvc.mvcframework.annotations.LagouController;
import com.wugz.mvc.mvcframework.annotations.LagouRequestMapping;
import com.wugz.mvc.mvcframework.annotations.MySecurity;
import com.wugz.mvc.mvcframework.demo.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {


    @LagouAutowired
    private IDemoService demoService;


    /**
     * URL: /demo/query?name=lisi
     * @param request
     * @param response
     * @param name
     * @return
     */
    @LagouRequestMapping("/query")
    @MySecurity({"zhangsan","lisi"})
    public String query(HttpServletRequest request, HttpServletResponse response,String name) {
        return demoService.get(name);
    }

    /**
     * URL: /demo/query?name=lisi
     * @param request
     * @param response
     * @param name
     * @return
     */
    @LagouRequestMapping("/get")
    public void get(HttpServletRequest request, HttpServletResponse response,String name) {
        try {
            response.getWriter().print("Hello Word");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
