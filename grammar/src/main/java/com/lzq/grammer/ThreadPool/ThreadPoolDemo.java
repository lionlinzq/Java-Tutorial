package com.lzq.grammer.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        ThreadPoolDemo test = new ThreadPoolDemo();
        test.useThreadPool();
    }

        

    public void useThreadPool() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() ->
            {
                runMethod(finalI + 1);
            });
        }

    }


    public void runMethod(int i) {
        Thread currentThread = Thread.currentThread();
        System.out.println("当前是=====" + currentThread.getName() + "线程在执行,接受的变量为" + i);
        System.out.println("\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
