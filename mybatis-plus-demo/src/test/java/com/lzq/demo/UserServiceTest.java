package com.lzq.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzq.demo.domain.TbUser;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.lzq.demo.daoservice.TbUserService;
import com.lzq.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void createUser() {
        TbUser user = new TbUser();
        user.setId(new Random().nextLong(2345252354l));
        user.setPhone("");
        user.setPassword("");
        user.setNickName("");
        user.setIcon("");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        tbUserService.save(user);
    }

    @Test
    public void getUser(){
        List<TbUser> list = tbUserService.list();
        System.out.println(list);

        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as maxId");
        Map<String, Object> map = tbUserService.getMap(wrapper);

        Long maxId = (Long) map.get("maxId");
        System.out.println(maxId);
    }

    @Test
    public void createUserOfThread() {
        userService.testMultiThreadCreateUser();
    }

    @Test
    public void testSaveOrUpdateUsers() {
        System.out.println(userService.saveOrUpdateUsers());
    }
}
