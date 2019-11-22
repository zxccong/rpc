package com.cn.spring_test.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zxccong
 * @date 2019/11/9
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SocketCmd {

    /**
     * 命令号
     * @return
     */
    short cmd();
}
