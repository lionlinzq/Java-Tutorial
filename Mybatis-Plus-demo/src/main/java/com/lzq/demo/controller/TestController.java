package com.lzq.demo.controller;

import com.github.jsonzou.jmockdata.JMockData;
import com.lzq.demo.domain.CartItems;
import com.lzq.demo.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

    @Autowired
    private CartItemsService cartItemsService;

    @PostMapping("/add")
    @ResponseBody
    public void test(){
        CartItems cartItems = JMockData.mock(CartItems.class);
        cartItemsService.save(cartItems);
    }
}
