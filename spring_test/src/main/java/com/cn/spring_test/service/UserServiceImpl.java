package com.cn.spring_test.service;

import org.springframework.stereotype.Component;

/**
 * @author zxccong
 * @date 2019/11/9
 */
@Component
public class UserServiceImpl implements UserService {

    public void login() {
        System.out.println("login");
    }

    public void getInfo() {
        System.out.println("getInfo");
    }
}
