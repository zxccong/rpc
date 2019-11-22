package com.cn.spring_test.service;

import com.cn.spring_test.annotion.SocketCmd;
import com.cn.spring_test.annotion.SocketModule;

/**
 * @author zxccong
 * @date 2019/11/9
 */
@SocketModule(module = 1)
public interface UserService {

    /**
     * 登录
     */
    @SocketCmd(cmd = 1)
    public void login();

    /**
     * 获取信息
     */
    @SocketCmd(cmd = 2)
    public void getInfo();

}
