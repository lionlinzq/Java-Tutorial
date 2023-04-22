package com.lzq.demo.service.impl;

import com.lzq.demo.service.CartItemsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class CartItemsServiceImplTest {

    @Autowired
    private CartItemsService cartItemsService;


    @Test
    public void test(){
        cartItemsService.list();
    }
}
