package com.example.aspectlab1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aspectlab1.controller.*.*(..))")
    public void beforeControllerMethod() {
        System.out.println("LoggingAspect: A controller method is about to be called.");
    }
}
