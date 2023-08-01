package com.lzq.grammer.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程本地例子
 *
 * @author lionlinzq
 * @date 2023/7/31 14:04
 */
@Slf4j
public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(1);
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(2);
        });
        thread1.start();
        thread2.start();


    }
}
