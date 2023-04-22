package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Reviews;
import com.lzq.demo.service.ReviewsService;
import com.lzq.demo.mapper.ReviewsMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【reviews】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class ReviewsServiceImpl extends ServiceImpl<ReviewsMapper, Reviews>
    implements ReviewsService{

}




