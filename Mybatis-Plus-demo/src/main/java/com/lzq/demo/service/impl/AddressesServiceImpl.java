package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Addresses;
import com.lzq.demo.mapper.AddressesMapper;
import com.lzq.demo.service.AddressesService;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【addresses】的数据库操作Service实现
* @createDate 2023-04-27 23:57:12
*/
@Service
public class AddressesServiceImpl extends ServiceImpl<AddressesMapper, Addresses>
    implements AddressesService {

}




