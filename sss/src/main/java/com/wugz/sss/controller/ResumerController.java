package com.wugz.sss.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wugz.sss.pojo.Resume;
import com.wugz.sss.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ResumerController
 * @Description
 * @Author wugz
 * @Date 2020/3/14 17:39
 * @Version 1.0
 */
@Controller
@RequestMapping("/resumer")
public class ResumerController {

    @Autowired
    private ResumeService resumeService;


    /**
     * @Description: 返回履历列表
     * @param
     * @Date: 2020/3/14 22:34
     * @Author: wuguizhen
     * @Return java.lang.Object
     * @Throws
     */
    @RequestMapping("/")
    public Object page(){
        return "/resumer/list";
    }

    /**
     * @Description: 返回履历列表
     * @param 
     * @Date: 2020/3/14 22:34
     * @Author: wuguizhen
     * @Return java.lang.Object
     * @Throws
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        /** 根据layui的要求 封装参数 */
        JSONObject result = new JSONObject();
        result.put("code","0");
        result.put("data",resumeService.findByJpql());
        return JSON.toJSONString(result, SerializerFeature.PrettyFormat);
    }

    @RequestMapping("/add/page")
    public String addPage(){
        return "/resumer/add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody Resume resume){
        System.out.println("resume开始插入，参数：" + resume.toString());
        resumeService.save(resume);
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id){
        resumeService.delete(id);
        return "success";
    }


    /**
     * @Description: 修改页面
     * @param
     * @Date: 2020/3/15 11:56
     * @Author: wuguizhen
     * @Return java.lang.String
     * @Throws
     */
    @RequestMapping("/edit/page")
    public String editPage(){
        return "/resumer/edit";
    }

    /**
     * @Description: 修改方法
     * @param resume
     * @Date: 2020/3/15 11:57
     * @Author: wuguizhen
     * @Return java.lang.String
     * @Throws
     */
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(@RequestBody Resume resume){
        System.out.println("resume开始修改，参数：" + resume.toString());
        resumeService.update(resume);
        return "success";
    }

}
