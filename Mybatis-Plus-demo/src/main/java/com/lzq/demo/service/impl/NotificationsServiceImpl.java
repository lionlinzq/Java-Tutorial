package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Notifications;
import com.lzq.demo.service.NotificationsService;
import com.lzq.demo.mapper.NotificationsMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【notifications】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class NotificationsServiceImpl extends ServiceImpl<NotificationsMapper, Notifications>
    implements NotificationsService{

}




