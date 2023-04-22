package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.CartItems;
import com.lzq.demo.service.CartItemsService;
import com.lzq.demo.mapper.CartItemsMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【cart_items】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class CartItemsServiceImpl extends ServiceImpl<CartItemsMapper, CartItems>
    implements CartItemsService{

}




