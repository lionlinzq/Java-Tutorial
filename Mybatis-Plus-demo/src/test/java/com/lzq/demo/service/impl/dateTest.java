package com.lzq.demo.service.impl;

import org.junit.Test;

import java.time.LocalDateTime;

public class dateTest {

    @Test
    public void testLocalDate(){
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);

        System.out.println(nowTime.plusDays(7));

        System.out.println(nowTime.plusMonths(1));

        System.out.println(nowTime.plusMonths(2));

    }
    
}
