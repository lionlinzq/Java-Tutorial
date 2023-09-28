package com.lzq.grammer.finaltest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lionlinzq
 * @date 2023/7/31 11:19
 */
@Slf4j
public class FinalDemo {

    // 普通域
    private int a;

    // final域
    private final int b;

    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1;
        b = 2;
        log.debug(Thread.currentThread().getName() + " a = {}, b = {}", a, b);
    }

    public static void writer(){
        finalDemo = new FinalDemo();
    }

    public static void reader(){
        FinalDemo demo = finalDemo;
        int a = demo.a;
        int b = demo.b;
        log.debug(Thread.currentThread().getName() + " a = {}, b = {}", a, b);
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(FinalDemo::writer);
        service.execute(FinalDemo::reader);
    }
}
