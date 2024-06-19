package com.sihai.sihairpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * 配置工具类
 * 读取配置文件并返回配置对象, 简化调用
 */
public class ConfigUtils {

    /**
     * 加载配置对象
     *
     * @param tClass
     * @param prefix
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass, prefix, "");
    }

    /**
     * 加载配置对象，支持区分环境
     *
     * @param tClass
     * @param prefix
     * @param environment 环境
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }
        // 可能的配置文件扩展名列表
        String[] extensions = {".yml", ".yaml", ".properties"};

        Props props = null;
        for (String extension : extensions) {
            try {
                props = new Props(configFileBuilder + extension);
                // 成功加载则跳出循环
                break;
            } catch (Exception ignored) {
                // 忽略异常，继续尝试下一个扩展名
            }
        }

        if (props == null) {
            throw new RuntimeException("No configuration file found for any of the supported formats: .yml, .yaml, .properties.");
        }

        return props.toBean(tClass, prefix);
    }
}