package com.sihai.sihairpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Mock 服务代理(JDK 动态代理)
 * 用于生成 Mock 代理服务对象
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler {

    /**
     * 调用代理方法
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 根据方法的返回值类型，生成特定的默认值对象
        Class<?> methodReturnType = method.getReturnType();
        log.info("模拟服务代理调用方法 MockServiceProxy invoke method: {}", method.getName());
        return getDefaultObject(methodReturnType);
    }

    /**
     * 生成指定类型的默认值对象
     */
    private Object getDefaultObject(Class<?> type) {
        if (type.isPrimitive()) {
            if (type == int.class) {
                return 0;
            } else if (type == long.class) {
                return 0L;
            } else if (type == float.class) {
                return 0.0f;
            } else if (type == double.class) {
                return 0.0d;
            } else if (type == boolean.class) {
                return false;
            } else if (type == char.class) {
                return '\u0000';
            } else if (type == byte.class) {
                return 0;
            } else if (type == short.class) {
                return (short) 0;
            }
        }
        // 对象类型
        return null;
    }
}
