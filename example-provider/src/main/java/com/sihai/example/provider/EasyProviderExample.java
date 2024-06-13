package com.sihai.example.provider;

import com.sihai.example.common.service.UserService;
import com.sihai.sihairpc.registry.LocalRegistry;
import com.sihai.sihairpc.server.HttpServer;
import com.sihai.sihairpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }

}
