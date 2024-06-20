package com.sihai.sihairpc.serializer.factory;

import com.sihai.sihairpc.serializer.Serializer;
import com.sihai.sihairpc.serializer.SerializerKeys;
import com.sihai.sihairpc.serializer.hessian.HessianSerializer;
import com.sihai.sihairpc.serializer.java.JdkSerializer;
import com.sihai.sihairpc.serializer.json.JsonSerializer;
import com.sihai.sihairpc.serializer.kryo.KryoSerializer;
import com.sihai.sihairpc.spi.SpiLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 序列化器工厂（用于获取序列化器对象）
 * 通过 SPI 加载指定的 Serializer 实现类
 */
public class SerializerFactory {

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }

}