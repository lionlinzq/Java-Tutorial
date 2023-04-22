package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Messages;
import com.lzq.demo.service.MessagesService;
import com.lzq.demo.mapper.MessagesMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【messages】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages>
    implements MessagesService{

}




