package com.lzq.demo.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;


public class ListTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User{
        public String name;
        public Integer age;
        public Integer id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name) && Objects.equals(id, user.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
    }

    @Test
    public void testTwoListDistinct(){
        List<User> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("张三");
            user.setAge(new Random().nextInt(20));
            list1.add(user);
        }

        List<User> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user2 = new User();
            user2.setName("张三");
            user2.setAge(new Random().nextInt(20));
            list2.add(user2);
        }

        System.out.println(list1);
        System.out.println(list2);

        Set<User> set = new HashSet<>(list1);
        set.addAll(list2);
        System.out.println(set);

        HashSet<String> strings = new HashSet<>();
        System.out.println(strings.size());
    }
}
