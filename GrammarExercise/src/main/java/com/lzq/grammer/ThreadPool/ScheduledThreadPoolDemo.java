package com.lzq.grammer.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        Integer integer = 0;
        int maxValue = Integer.MAX_VALUE;
        System.out.println("[Integer.MAX_VALUE] = " + maxValue);

        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 验证是否是在三秒后执行
        System.out.println(df2.format(System.currentTimeMillis()));

        ExecutorService scheduledPool = Executors.newScheduledThreadPool(1);  // 创建定时的线程池 核心数量 2
        ScheduledThreadDemo thread = new ScheduledThreadDemo();

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始执行：" + df2.format(System.currentTimeMillis()));
                System.out.println("开启任务 task2");
            }
        };

        ((ScheduledExecutorService) scheduledPool).schedule(thread, 3, TimeUnit.SECONDS);        // 1.对于thread  2. 延迟时间3后执行任务 3.单位TimeUnit.SECONDS 是 【秒】 三秒后执行
        ((ScheduledExecutorService) scheduledPool).schedule(task2, 5, TimeUnit.SECONDS);        // 延迟5秒后执行任务

        scheduledPool.shutdown();
    }
}

class ScheduledThreadDemo extends Thread {
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(System.currentTimeMillis()));
        System.out.println("我是线程1， 我在运行");
        System.out.println("正在运行的线程名字" + Thread.currentThread().getName());
    }

}
