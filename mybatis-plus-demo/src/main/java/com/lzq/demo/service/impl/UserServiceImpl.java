package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    private IdWorker idWorker;

    ExecutorService executorService = Executors.newFixedThreadPool(5);


    @Override
    public void testMultiThreadCreateUser() {

    }

    @Override
    public void testDsTransaction() {

    }

    @Override
    public boolean saveOrUpdateUsers() {
        return false;
    }
}
