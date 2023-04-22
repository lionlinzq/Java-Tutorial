package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Carts;
import com.lzq.demo.service.CartsService;
import com.lzq.demo.mapper.CartsMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【carts】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class CartsServiceImpl extends ServiceImpl<CartsMapper, Carts>
    implements CartsService{

}




