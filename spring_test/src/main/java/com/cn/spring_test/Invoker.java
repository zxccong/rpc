package com.cn.spring_test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zxccong
 * @date 2019/11/9
 */
@Getter
@Setter
public class Invoker {

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 方法
     */
    private Method method;

    public static Invoker valueOf(Object object, Method method) {
        Invoker invoker = new Invoker();
        invoker.setTarget(object);
        invoker.setMethod(method);
        return invoker;
    }

    public Object invoke(Object... args) {
        try {
            method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
