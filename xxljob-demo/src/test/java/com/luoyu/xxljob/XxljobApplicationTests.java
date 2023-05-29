package com.luoyu.xxljob;

import com.luoyu.xxljob.domain.XxlJobInfo;
import com.luoyu.xxljob.utils.XxlJobUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@Slf4j
// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest
class XxljobApplicationTests {


    @Autowired
    private Environment env;

    @Value("${xxl.job.executor.appname}")
    private String appName;


    @BeforeEach
    void testBefore() {
        log.info("测试开始!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @AfterEach
    void testAfter() {
        log.info("测试结束!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Test
    public void testGetAppName(){
        System.out.println(appName);
    }

    @Test
    public void testAroundHellman() {
        XxlJobUtil util = new XxlJobUtil();
        XxlJobInfo info = new XxlJobInfo();
        info.setAuthor("lzq");
        info.setJobDesc("问卷123");
        info.setScheduleConf("* * * * * ?");
        info.setGlueType("BEAN");
        info.setExecutorHandler("demo");
        info.setExecutorParam("{\"json\":\"123\"}");

        // 获取配置信息
        String appName = env.getProperty("xxl.job.executor.appname");
        util.add(info);
    }

}
