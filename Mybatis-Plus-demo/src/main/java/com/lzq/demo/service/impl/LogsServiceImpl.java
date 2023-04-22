package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Logs;
import com.lzq.demo.service.LogsService;
import com.lzq.demo.mapper.LogsMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【logs】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs>
    implements LogsService{

}




