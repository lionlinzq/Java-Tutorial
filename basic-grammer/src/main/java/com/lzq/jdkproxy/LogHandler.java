package com.lzq.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {

    // 被代理的对象，实际的方法执行者
    Object target;

    public LogHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        // 调用 target 的 method 方法
        Object result = method.invoke(target, args);
        after();
        // 返回方法的执行结果
        return result;
    }

    // 调用invoke方法之前执行
    private void before() {
        System.out.println(String.format("动态代理:log start time [%s] ", new Date()));
    }

    // 调用invoke方法之后执行
    private void after() {
        System.out.println(String.format("动态代理:log end time [%s] ", new Date()));
    }
}
