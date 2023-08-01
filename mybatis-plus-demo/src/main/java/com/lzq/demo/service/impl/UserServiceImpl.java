package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzq.demo.daoservice.TbSignService;
import com.lzq.demo.daoservice.TbUserService;
import com.lzq.demo.domain.TbSign;
import com.lzq.demo.domain.TbUser;
import com.lzq.demo.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lzq.demo.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserService userService;

    @Autowired
    private TbSignService tbSignService;

    @Autowired
    private IdWorker idWorker;

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    public void testMultiThreadCreateUser() {
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println("thread id is: " + Thread.currentThread().getId());
                QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
                wrapper.select("max(id) as maxId");
                Map<String, Object> map = userService.getMap(wrapper);
                Long maxId = (Long) map.get("maxId");
                System.out.println(maxId);

                TbUser user = new TbUser();
                user.setId(maxId + 1);
                user.setPhone("");
                user.setPassword("");
                user.setNickName("");
                user.setIcon("");
                user.setCreateTime(LocalDateTime.now());
                user.setUpdateTime(LocalDateTime.now());
                userService.save(user);
            });
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void testDsTransaction() {
        TbSign tx = new TbSign();
        tx.setId(1L);
        tx.setUserId(0L);
        tx.setYear(1);
        tx.setMonth(0);
        tx.setDate(LocalDate.now());
        tx.setIsBackup(0);
        tbSignService.save(tx);

        TbUser user = new TbUser();
        user.setId(22L);
        user.setPhone("");
        user.setPassword("");
        user.setNickName("");
        user.setIcon("");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        userService.save(user);
    }

    @Override
    public boolean saveOrUpdateUsers() {
        List<TbUser> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(idWorker.nextId());
            TbUser user = new TbUser();
            user.setId(idWorker.nextId());
            user.setPhone(String.format(new String("1351234%d"), new Random().nextInt(1000)));
            user.setPassword("123456");
            user.setNickName("nicoName");
            user.setIcon("ICON");
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            userList.add(user);
        }
        return userService.saveBatch(userList);
    }


}
