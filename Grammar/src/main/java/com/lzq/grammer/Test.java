package com.lzq.grammer;

import com.lzq.grammer.utils.ThreadPoolUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Test {
    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }

    /**
     * 测试try catch
     */
    public static void testTryCatch() {
        try {
            try {
                int i = 1 / 0;
            } catch (Exception e) {
                log.error("子方法捕捉到异常", e);
            }
            int a = 2 / 0;
        } catch (Exception e) {
            log.error("主方法逻辑捕捉到异常", e);
        }
    }

    public static void test1() throws InterruptedException {
        ThreadPoolUtils pool = new ThreadPoolUtils(5,5,10, "A业务线程池");
        // 14个正常任务
        for (int i = 0; i < 14; i++){
            pool.execute(() -> {
                try {
                    // 模拟任务耗时
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String taskName = randomName();
                System.out.println(Thread.currentThread().getName() + "-执行【" + taskName + "】");
            });
        }
        // 1个异常任务
        pool.execute(() -> {
            String taskName = randomName();
            throw new RuntimeException("执行【" + taskName + "】" + "异常");
        });
        // 5个多余用来拒绝的任务
        for (int i = 0; i < 5; i++){
            pool.execute(() -> {
                throw new RuntimeException("多余任务");
            });
        }
        System.out.println("任务完成情况：" + pool.getExecuteResult());

        pool.shutdown();

        Thread.sleep(20000);
    }
    public static void test2() throws InterruptedException {
        ThreadPoolUtils pool = new ThreadPoolUtils(5,5,10, "A业务线程池");
        // 14个正常任务
        for (int i = 0; i < 14; i++){
            pool.execute(new ThreadPoolUtils.SimpleTask() {
                @Override
                public void run() {
                    try {
                        // 模拟任务耗时
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 随机名称
                    String taskName = randomName();
                    super.setTaskName(taskName);
                    System.out.println(Thread.currentThread().getName() + "-执行【" + taskName + "】");
                }
            });
        }
        // 1个异常任务
        pool.execute(new ThreadPoolUtils.SimpleTask() {
            @Override
            public void run() {
                // 随机名称
                String taskName = randomName();
                super.setTaskName(taskName);
                throw new RuntimeException("执行【" + taskName + "】" + "异常");
            }
        });
        // 5个多余用来拒绝的任务
        for (int i = 0; i < 5; i++){
            pool.execute(new ThreadPoolUtils.SimpleTask() {
                @Override
                public void run() {
                    // 随机名称
                    String taskName = randomName();
                    super.setTaskName(taskName);
                    throw new RuntimeException("多余任务");
                }
            });
        }
        System.out.println("任务完成情况：" + pool.getExecuteResult());

        pool.shutdown();

        Thread.sleep(20000);
    }

    private static String randomName(){
        return "任务" + (char) (new Random().nextInt(60) + 65);
    }
}
