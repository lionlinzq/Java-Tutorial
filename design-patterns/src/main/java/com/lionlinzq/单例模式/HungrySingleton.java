package com.lionlinzq.单例模式;

/**
 * 饥饿模式: 类加载时就初始化
 */
final class HungrySingleton {
    /** 实例对象 */
    private static HungrySingleton instance = new HungrySingleton();

    /** 禁用构造方法 */
    private HungrySingleton() { }

    /**
     * 获取单例对象, 直接返回已创建的实例
     * @return instance 本类的实例
     */
    public static HungrySingleton getInstance() {
        return instance;
    }
}
