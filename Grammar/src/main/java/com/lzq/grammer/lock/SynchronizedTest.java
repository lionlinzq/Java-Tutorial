package com.lzq.grammer.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步测试
 *
 * @author Lin
 * @date 2023/07/26
 */
@Slf4j
public class SynchronizedTest {

    private ReentrantLock reentrantLock;

    public static void main(String[] args) {
        SynchronizedTest s1 = new SynchronizedTest();
        SynchronizedTest s2 = new SynchronizedTest();
        s1.lockMethod();
        s1.lockCodeBlock();

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 1、锁住方法，锁的是实例对象，不同实例对象之间不会同步
        // log.info("锁住方法测试");
        // executorService.execute(s1::lockMethod);
        // executorService.execute(s2::lockMethod);
        // log.info("========================");

        // 2、锁住代码块，锁的也是实例对象，不同实例对象之间不会同步
        log.info("锁住代码块测试");
        executorService.execute(s1::lockCodeBlock);
        executorService.execute(s2::lockCodeBlock);
        log.info("========================");

        // 3、锁住类，不同的实例对象调用方法也会进行同步
        // log.info("锁住class对象测试");
        // executorService.execute(s1::lockClass);
        // executorService.execute(s2::lockClass);
    }


    /**
     * 锁住方法,作用于同一个对象，多个线程调用同一个实例的方法，会进行同步
     * 多个线程调用不同的实例对象的方法，不会进行同步
     */
    public synchronized void lockMethod() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(i + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 锁代码块
     */
    public void lockCodeBlock() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print(i + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 锁类
     */
    public void lockClass() {
        synchronized(SynchronizedTest.class) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print(i + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
