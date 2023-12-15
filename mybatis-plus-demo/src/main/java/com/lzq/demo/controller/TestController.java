package com.lzq.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @PostMapping("testDsTransaction")
    public Integer test() {
        Integer a = null;
        return a;
    }
}
