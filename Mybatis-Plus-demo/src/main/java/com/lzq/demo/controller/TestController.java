package com.lzq.demo.controller;

import com.lzq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("testDsTransaction")
    public void test(){
        userService.testDsTransaction();
    }
}
