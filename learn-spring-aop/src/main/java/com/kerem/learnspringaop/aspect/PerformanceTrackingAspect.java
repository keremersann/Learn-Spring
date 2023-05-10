package com.kerem.learnspringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution (* com.kerem.learnspringaop.*.*.*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        long stopTime = System.currentTimeMillis();
        long executionTime = stopTime - startTime;
        logger.info("Around Aspect - Method is called {} - in {} ms", proceedingJoinPoint, executionTime);

        return returnedValue;
    }
}
