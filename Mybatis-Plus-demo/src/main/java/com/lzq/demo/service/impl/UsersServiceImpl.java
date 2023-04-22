package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Users;
import com.lzq.demo.service.UsersService;
import com.lzq.demo.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




