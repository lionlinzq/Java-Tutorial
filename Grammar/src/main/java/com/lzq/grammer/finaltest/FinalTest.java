package com.lzq.grammer.finaltest;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * final关键字测试
 *
 * @author Lin
 * @date 2023/07/31
 */
@Slf4j
public class FinalTest {

    static Random r = new Random();
    final int k = r.nextInt(10);
    static final int k2 = r.nextInt(10);
    public static void main(String[] args) {
        log.info("初始化类的两个实例");
        FinalTest t1 = new FinalTest();
        log.info("对于类1,k="+t1.k+" k2="+ k2);
        FinalTest t2 = new FinalTest();
        log.info("对于类2,k="+t2.k+" k2="+ k2);
    }


}
