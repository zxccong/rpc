package com.cn.spring_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zxccong
 * @date 2019/11/13
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Invoker invoker = InvokerHolder.getInvoker((short) 1, (short) 1);

        invoker.invoke(null);


    }
}
