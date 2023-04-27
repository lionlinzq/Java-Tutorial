package com.lzq.demo.controller;

import com.github.jsonzou.jmockdata.JMockData;
import com.lzq.demo.domain.Addresses;
import com.lzq.demo.domain.CartItems;
import com.lzq.demo.service.AddressesService;
import com.lzq.demo.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/test")
public class TestController {

    @Autowired
    private CartItemsService cartItemsService;

    @Autowired
    private AddressesService addressesService;

    @PostMapping("/add")
    @ResponseBody
    public void test(){
        CartItems cartItems = JMockData.mock(CartItems.class);
        cartItemsService.save(cartItems);
    }

    @PostMapping("/addAddress")
    @ResponseBody
    public boolean addAddress(Addresses addresses){
        boolean save = addressesService.save(addresses);
        return save;
    }

    @PostMapping("list")
    @ResponseBody
    public List<Addresses> list(){
        List<Addresses> list = addressesService.list();
        return list;
    }
}
