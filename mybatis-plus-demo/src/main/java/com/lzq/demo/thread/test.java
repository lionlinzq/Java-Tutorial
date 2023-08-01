package com.lzq.demo.thread;

import com.lzq.demo.daoservice.TbSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
public class test {

    @Autowired
    private TbSignService service;

    @Scheduled(cron = "*/10 * * * * *")
    public void test1() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println("thread id is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(5000L);
                    runMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void runMethod() throws InterruptedException {
        int i = 1;
        for (int j = 1; j < 10; j++) {
            i = i * j;
        }
        Thread.sleep(200);
        System.out.println("========" + i + "=============");
    }
}
