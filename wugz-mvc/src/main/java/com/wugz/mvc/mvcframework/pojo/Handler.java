package com.wugz.mvc.mvcframework.pojo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * 封装handler方法相关的信息
 */
public class Handler {

    private Object controller; // method.invoke(obj,)

    private Method method;

    private Pattern pattern; // spring中url是支持正则的

    private Map<String,Integer> paramIndexMapping; // 参数顺序,是为了进行参数绑定，key是参数名，value代表是第几个参数 <name,2>

    // 权限列表 表明哪些用户拥有访问该Handler方法的权限 在自定义注解中@MySecurity 中配置
    private List<String> securitys;

    public List<String> getSecuritys() {
        return securitys;
    }

    public void setSecuritys(List<String> securitys) {
        this.securitys = securitys;
    }

    public Handler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        this.paramIndexMapping = new HashMap<>();
        this.securitys = new ArrayList<>();
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Map<String, Integer> getParamIndexMapping() {
        return paramIndexMapping;
    }

    public void setParamIndexMapping(Map<String, Integer> paramIndexMapping) {
        this.paramIndexMapping = paramIndexMapping;
    }
}
