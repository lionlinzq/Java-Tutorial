package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Products;
import com.lzq.demo.service.ProductsService;
import com.lzq.demo.mapper.ProductsMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【products】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
    implements ProductsService{

}




