package com.sihai.example.common.service;

import com.sihai.example.common.model.User;

/**
 * 用户服务接口
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);
}
