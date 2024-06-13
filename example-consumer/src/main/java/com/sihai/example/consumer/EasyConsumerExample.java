package com.sihai.example.consumer;

import com.sihai.example.common.model.User;
import com.sihai.example.common.service.UserService;
import com.sihai.sihairpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // 调用动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);;
        User user = new User();
        user.setName("sihai");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }

}