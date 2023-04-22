package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Orders;
import com.lzq.demo.service.OrdersService;
import com.lzq.demo.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




