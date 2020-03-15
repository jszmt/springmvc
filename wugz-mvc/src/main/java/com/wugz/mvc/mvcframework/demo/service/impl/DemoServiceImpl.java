package com.wugz.mvc.mvcframework.demo.service.impl;


import com.wugz.mvc.mvcframework.annotations.LagouService;
import com.wugz.mvc.mvcframework.demo.service.IDemoService;

@LagouService("demoService")
public class DemoServiceImpl implements IDemoService {
    @Override
    public String get(String name) {
        System.out.println("service 实现类中的name参数：" + name) ;
        return name;
    }
}
