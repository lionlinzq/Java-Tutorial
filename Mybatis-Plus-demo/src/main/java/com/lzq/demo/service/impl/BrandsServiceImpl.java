package com.lzq.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Brands;
import com.lzq.demo.mapper.BrandsMapper;
import com.lzq.demo.service.BrandsService;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【brands】的数据库操作Service实现
* @createDate 2023-04-27 23:57:12
*/
@Service
public class BrandsServiceImpl extends ServiceImpl<BrandsMapper, Brands>
    implements BrandsService {

}




