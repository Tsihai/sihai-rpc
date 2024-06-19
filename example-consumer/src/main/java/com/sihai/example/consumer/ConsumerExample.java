package com.sihai.example.consumer;

import com.sihai.example.common.model.User;
import com.sihai.example.common.service.UserService;
import com.sihai.sihairpc.config.RpcConfig;
import com.sihai.sihairpc.proxy.ServiceProxyFactory;
import com.sihai.sihairpc.utils.ConfigUtils;
/**
 * 简易服务消费者示例
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("sihai");
        // 调用方法
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("调用失败, 用户为空");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}