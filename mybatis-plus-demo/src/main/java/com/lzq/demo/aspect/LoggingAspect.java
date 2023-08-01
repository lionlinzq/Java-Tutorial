package com.lzq.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.lzq.demo.controller.*Controller.*(..))")
    public Object logRequestAndResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        // 获取请求方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取请求类名
        String className = joinPoint.getTarget().getClass().getSimpleName();
        // 打印请求日志
        logger.info("Request: {}.{}({})", className, methodName, Arrays.toString(args));
        // 执行请求方法并获取响应结果
        Object result = joinPoint.proceed();
        // 打印响应日志
        logger.info("Response: {}", result);
        return result;
    }
}
