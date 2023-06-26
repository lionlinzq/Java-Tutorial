package com.lzq.grammer;

import com.lzq.grammer.entity.User;


public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUsername("张三");
        user1.setPassword("123456");
        user1.setUserId(1);
        user1.setStoreId(1);

        User user2 = new User();
        user2.setUsername("张三");
        user2.setPassword("1234567");
        user2.setUserId(1);
        user2.setStoreId(1);

        System.out.println(user1.equals(user2));

    }
}