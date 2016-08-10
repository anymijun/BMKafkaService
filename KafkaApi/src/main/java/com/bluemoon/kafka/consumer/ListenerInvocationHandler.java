package com.bluemoon.kafka.consumer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 *
 * Created by LeonWong on 16/8/9.
 */
public class ListenerInvocationHandler implements InvocationHandler {

    private Object tar;

    public Object bind(Object object) {
        this.tar = object;
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        result = method.invoke(tar, args);
        return result;
    }
}
