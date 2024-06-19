package com.sihai.example.consumer;

import com.sihai.sihairpc.config.RpcConfig;
import com.sihai.sihairpc.utils.ConfigUtils;
/**
 * 简易服务消费者示例
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 配置文件读取
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}