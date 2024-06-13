package com.sihai.example.provider;

import com.sihai.example.common.model.User;
import com.sihai.example.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }

}
