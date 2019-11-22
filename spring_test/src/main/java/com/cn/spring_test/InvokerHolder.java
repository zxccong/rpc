package com.cn.spring_test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxccong
 * @date 2019/11/13
 */
public class InvokerHolder {

    /**
     * 保存所有的执行器
     */
    public static Map<Short, Map<Short, Invoker>> invokers = new HashMap<Short, Map<Short, Invoker>>();


    /**
     * 添加执行器
     * @param module
     * @param cmd
     * @param invoker
     */
    public static void addInvoker(short module, short cmd, Invoker invoker) {
        Map<Short, Invoker> map = invokers.get(module);
        if (map == null) {
            map = new HashMap<Short, Invoker>();
            invokers.put(module, map);
        }

        map.put(cmd, invoker);
    }

    /**
     * 获取执行器
     * @param module
     * @param cmd
     * @return
     */
    public static Invoker getInvoker(short module, short cmd) {
        Map<Short, Invoker> map = invokers.get(module);
        if (map != null) {
            return map.get(cmd);
        }
        return null;

    }



}
