package com.lzq.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Categories;
import com.lzq.demo.mapper.CategoriesMapper;
import com.lzq.demo.service.CategoriesService;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【categories】的数据库操作Service实现
* @createDate 2023-04-27 23:57:12
*/
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories>
    implements CategoriesService {

}




