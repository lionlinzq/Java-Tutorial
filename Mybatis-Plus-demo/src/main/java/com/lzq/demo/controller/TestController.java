package com.lzq.demo.controller;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzq.demo.domain.Addresses;
import com.lzq.demo.domain.CartItems;
import com.lzq.demo.mapper.AddressesMapper;
import com.lzq.demo.service.AddressesService;
import com.lzq.demo.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/test")
public class TestController {

    @Autowired
    private CartItemsService cartItemsService;

    @Autowired
    private AddressesService addressesService;

    @Autowired
    private AddressesMapper addressesMapper;

    @PostMapping("/add")
    @ResponseBody
    public void test() {
        CartItems cartItems = JMockData.mock(CartItems.class);
        cartItemsService.save(cartItems);
    }

    @PostMapping("/addAddress")
    @ResponseBody
    public boolean addAddress(@RequestBody Addresses addresses) {
        System.out.println(addresses.toString());
        boolean save = addressesService.save(addresses);
        return save;
    }

    @PostMapping("list")
    @ResponseBody
    public List<Addresses> list() {
        List<Addresses> list = addressesService.list();
        return list;
    }

    @PostMapping("pageList")
    @ResponseBody
    public PageInfo<Addresses> pageList() {
        PageInfo<Addresses> pageInfo = PageHelper.startPage(1, 2)
                .doSelectPageInfo(() -> addressesMapper.selectById(1651860293375062017L));
        System.out.println(pageInfo);
        return pageInfo;
    }

    @DeleteMapping("deleteAll")
    @ResponseBody
    public int deleteAll(){
        int delete = addressesMapper.delete(null);
        return delete;
    }
}
