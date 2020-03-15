package com.wugz.mvc.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * @ClassName MySecurity
 * @Description 自定义权限注解
 * @Author wugz
 * @Date 2020/3/14 12:27
 * @Version 1.0
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MySecurity {
    String[] value();
}
