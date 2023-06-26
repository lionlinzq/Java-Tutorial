package com.lzq.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lzq.demo.domain.TbUser;
import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class JacksonTest {

    ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @Test
    public void test0(){

        TbUser user = new TbUser();
        user.setId(1L);
        user.setPhone("13512345678");
        user.setPassword("123456");
        user.setNickName("nick");
        user.setIcon("icon");
        // user.setCreateTime(LocalDateTime.now());
        // user.setUpdateTime(LocalDateTime.now());
        ArrayList<TbUser> tbUsers = new ArrayList<>();
        tbUsers.add(user);
        System.out.println(tbUsers);
        String string = mapper.writeValueAsString(tbUsers);
        System.out.println(string);

    }
}
