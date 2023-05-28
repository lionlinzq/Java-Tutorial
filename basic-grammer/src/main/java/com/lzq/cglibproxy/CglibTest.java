package com.lzq.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        LogInterceptor daoProxy = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        // 设置超类，cglib是通过继承来实现的
        enhancer.setSuperclass(LogInterceptor.class);
        enhancer.setCallback(daoProxy);

        // 创建代理类
        UserDao dao = (UserDao) enhancer.create();
        dao.update();
        dao.select();
    }
}
