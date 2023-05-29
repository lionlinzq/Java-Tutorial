package com.luoyu.xxljob.service;

import com.luoyu.xxljob.domain.XxlJobInfo;
import com.luoyu.xxljob.utils.XxlJobUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.thread.JobThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * XxlJob开发示例（Bean模式）
 *
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobHelper.log" 打印执行日志；
 *
 * @author xuxueli 2019-12-11 21:52:51
 */
@Slf4j
@Component
public class XxlJobService {

    @Autowired
    private XxlJobExecutor xxlJobExecutor;


    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler() throws Exception {

        XxlJobUtil util = new XxlJobUtil();
        XxlJobInfo info = new XxlJobInfo();
        info.setAuthor("lzq");
        info.setJobDesc("问卷123");
        info.setScheduleConf("* * * * * ?");
        info.setGlueType("BEAN");
        info.setExecutorHandler("demo");
        info.setExecutorParam("{\"json\":\"123\"}");

        util.add(info);
        // long id = XxlJobHelper.getJobId();
        //
        // String jobParam = XxlJobHelper.getJobParam();
        // XxlJobHelper.log(jobParam);
        // XxlJobHelper.log(String.valueOf(id));
        //
        //
        //
        // XxlJobHelper.log("XXL-JOB, Hello World.");

        // System.out.println("看完小说了");
        // for (int i = 0; i < 5; i++) {
        //     XxlJobHelper.log("开始执行");
        //     XxlJobHelper.log("beat at:" + i);
        //     TimeUnit.SECONDS.sleep(2);
        // }
        return ReturnT.SUCCESS;
    }

    // /**
    //  * 2、分片广播任务
    //  */
    // @XxlJob("shardingJobHandler")
    // public ReturnT<String> shardingJobHandler(String param) throws Exception {
    //
    //     // 分片参数
    //     ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
    //     XxlJobHelper.log("分片参数：当前分片序号 = {}, 总分片数 = {}", shardingVO.getIndex(), shardingVO.getTotal());
    //
    //     // 业务逻辑
    //     for (int i = 0; i < shardingVO.getTotal(); i++) {
    //         if (i == shardingVO.getIndex()) {
    //             XxlJobHelper.log("第 {} 片, 命中分片开始处理", i);
    //         } else {
    //             XxlJobHelper.log("第 {} 片, 忽略", i);
    //         }
    //     }
    //
    //     return ReturnT.SUCCESS;
    // }

    /**
     * 3、命令行任务
     */
    @XxlJob("commandJobHandler")
    public ReturnT<String> commandJobHandler(String param) throws Exception {
        String command = param;
        int exitValue = -1;

        BufferedReader bufferedReader = null;
        try {
            // command process
            Process process = Runtime.getRuntime().exec(command);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            // command log
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                XxlJobHelper.log(line);
            }

            // command exit
            process.waitFor();
            exitValue = process.exitValue();
        } catch (Exception e) {
            XxlJobHelper.log(e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }


        return null;
    }

    /**
     * 4、跨平台Http任务
     */
    @XxlJob("httpJobHandler")
    public ReturnT<String> httpJobHandler(String param) throws Exception {

        // request
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        try {
            // connection
            URL realUrl = new URL(param);
            connection = (HttpURLConnection) realUrl.openConnection();

            // connection setting
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(5 * 1000);
            connection.setConnectTimeout(3 * 1000);
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("Accept-Charset", "application/json;charset=UTF-8");

            // do connection
            connection.connect();

            //Map<String, List<String>> map = connection.getHeaderFields();

            // valid StatusCode
            int statusCode = connection.getResponseCode();
            if (statusCode != 200) {
                throw new RuntimeException("Http Request StatusCode(" + statusCode + ") Invalid.");
            }

            // result
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            String responseMsg = result.toString();

            XxlJobHelper.log(responseMsg);
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            XxlJobHelper.log(e);
            return ReturnT.FAIL;
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e2) {
                XxlJobHelper.log(e2);
            }
        }

    }

    /**
     * 5、生命周期任务示例：任务初始化与销毁时，支持自定义相关逻辑；
     */
    @XxlJob(value = "demoJobHandler2", init = "init", destroy = "destroy")
    public ReturnT<String> demoJobHandler2(String param) throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        return ReturnT.SUCCESS;
    }

    public void init(){
        log.info("init");
    }

    public void destroy(){
        log.info("destory");
    }

}
