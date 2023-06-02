package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.PlReleaseRange;
import com.lzq.demo.mapper.PlReleaseRangeMapper;
import com.lzq.demo.service.PlReleaseRangeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author lin
* @description 针对表【pl_release_range(投放范围表)】的数据库操作Service实现
* @createDate 2023-05-27 00:18:47
*/
@Service
public class PlReleaseRangeServiceImpl extends ServiceImpl<PlReleaseRangeMapper, PlReleaseRange>
    implements PlReleaseRangeService{

    @Scheduled(cron = "*/5 * * * * *")
    @Override
    public void testSchdule() {
        Date date = new Date();
        System.out.println(System.currentTimeMillis());
    }
}




