package com.kerem.learnspringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    // Pointcut - when?
    // execution(* PACKAGE.*.*(..))
    // * com/kerem/learnspringaop/business.*.*(..)
    @Before("com.kerem.learnspringaop.aspect.CommonPointcutConfig.allServicesConfigWithBean()")
    public void logMethodCallBefore(JoinPoint joinPoint){
        logger.info("Before Aspect - Method is called {} - with args {}", joinPoint, joinPoint.getArgs());
    }
    @After("com.kerem.learnspringaop.aspect.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfter(JoinPoint joinPoint){
        logger.info("After Aspect - Method has executed {} - with args {}", joinPoint, joinPoint.getArgs());
    }
    @AfterThrowing(pointcut = "execution (* com.kerem.learnspringaop.*.*.*(..))",
                    throwing = "exception")
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception){
        logger.info("After Throwing Aspect - Method has executed {} - with args {} - exception {}", joinPoint, joinPoint.getArgs()
        , exception.getMessage());
    }
    @AfterReturning(pointcut = "com.kerem.learnspringaop.aspect.CommonPointcutConfig.repositoryPackageConfig()",
            returning = "resultValue")
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue){
        logger.info("After Returning Aspect - Method has executed {} - with args {} - Result value: {}", joinPoint, joinPoint.getArgs()
                , resultValue);
    }
}
