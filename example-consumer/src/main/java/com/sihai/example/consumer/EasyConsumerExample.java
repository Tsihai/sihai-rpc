package com.sihai.example.consumer;

import com.sihai.example.common.model.User;
import com.sihai.example.common.service.UserService;
import com.sihai.example.provider.UserServiceImpl;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // todo 需要获取 UserService 的实现类对象
        UserService userService = new UserServiceImpl();
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