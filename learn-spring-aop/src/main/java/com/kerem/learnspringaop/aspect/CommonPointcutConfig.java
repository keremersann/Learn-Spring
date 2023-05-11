package com.kerem.learnspringaop.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

public class CommonPointcutConfig {

    @Pointcut("execution (* com.kerem.learnspringaop.*.*.*(..))")
    public void businessAndDataPackageConfig(){}
    @Pointcut("execution (* com.kerem.learnspringaop.business.*.*(..))")
    public void businessPackageConfig(){}
    @Pointcut("execution (* com.kerem.learnspringaop.repository.*.*(..))")
    public void repositoryPackageConfig(){}

    @Pointcut("bean(*Service*)")
    public void allServicesConfigWithBean(){}

}
