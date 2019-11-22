package com.cn.spring_test;

import com.cn.spring_test.annotion.SocketCmd;
import com.cn.spring_test.annotion.SocketModule;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zxccong
 * @date 2019/11/9
 */
@Component
public class Scanner implements BeanPostProcessor {

    //在这里我们需要

    //在bean初始化之前执行
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//
//        return null;
//    }

    //在bean初始化之前执行
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //获取所有的类
        Class<?> clazz = bean.getClass();
        //获取所有的接口
        Class<?>[] interfaces = clazz.getInterfaces();

        if (interfaces != null && interfaces.length > 0) {
            //扫描所有接口
            for (Class<?> anInterface : interfaces) {
                SocketModule socketModule = anInterface.getAnnotation(SocketModule.class);
                if (socketModule == null) {
                    continue;
                }

                Method[] methods = anInterface.getMethods();

                if (methods != null && methods.length > 0) {
                    for (Method method : methods) {
                        SocketCmd socketCmd = method.getAnnotation(SocketCmd.class);
                        if (socketCmd == null) {
                            continue;
                        }

                        short module = socketModule.module();
                        short cmd = socketCmd.cmd();
                        Invoker invoker = Invoker.valueOf(bean, method);

                        if (InvokerHolder.getInvoker(module, cmd) == null) {
                            InvokerHolder.addInvoker(module,cmd,invoker);
                        } else {
                            System.out.println("重复注册执行器module:" + module + " cmd ：" + cmd);
                        }


                    }
                }

            }
        }


        return bean;
    }
}
