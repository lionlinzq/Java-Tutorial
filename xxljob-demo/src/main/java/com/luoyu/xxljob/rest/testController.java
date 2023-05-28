package com.luoyu.xxljob.rest;

import com.luoyu.xxljob.domain.XxlJobInfo;
import com.luoyu.xxljob.utils.XxlJobUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {


    @GetMapping("/test")
    public void test(){
        XxlJobUtil util = new XxlJobUtil();
        XxlJobInfo info = new XxlJobInfo();
        info.setAuthor("lzq");
        info.setJobDesc("问卷123");
        info.setScheduleConf("* * * * * ?");
        info.setGlueType("BEAN");
        info.setExecutorHandler("demo");
        info.setExecutorParam("{\"json\":\"123\"}");
        util.add(info);
    }
}
