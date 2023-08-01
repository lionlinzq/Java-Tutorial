package com.lzq.grammer.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 线程使用测试
 *
 * @author Lin
 * @date 2023/07/26
 */
@Slf4j
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 设置一个钩子，当JVN退出前打印日志
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> {
                    log.info("JVN退出啦!");
                }));

        // MyThread myThread = new MyThread();
        // myThread.start();
        //
        // MyRunnable myRunnable = new MyRunnable();
        // new Thread(myRunnable).start();
        //
        // MyCallable myCallable = new MyCallable();
        // FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        // Thread futureThread = new Thread(futureTask);
        // futureThread.start();
        // System.out.println("看一下有没有返回值" + futureTask.get());

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("子线程还在执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        // 主线程
        TimeUnit.SECONDS.sleep(2);

        System.out.println("主线程结束了，可以退出了");
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是继承了Thread的线程在执行");
        }
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("这是实现了Runnable接口的线程在执行");
        }
    }

    public static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("这是实现了Callable接口的线程在执行");
            try {
                int i = 1 / 0;
            } catch (Exception e) {
                log.debug("出现异常,记录一下,不处理:{}", e);
                throw e;
            }
            return 1;
        }
    }
}
