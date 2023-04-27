package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Payments;
import com.lzq.demo.mapper.PaymentsMapper;
import com.lzq.demo.service.PaymentsService;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【payments】的数据库操作Service实现
* @createDate 2023-04-27 23:57:12
*/
@Service
public class PaymentsServiceImpl extends ServiceImpl<PaymentsMapper, Payments>
    implements PaymentsService {

}




