package com.example.reservation.Logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.example.reservation.Services.*.*(..))")
    public void logMethodEntry (JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName () ;
        log.info("In method :" + name );
    }
    @After("execution(* com.example.reservation.Services.*.*(..))")
    public void logMethodExit (JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName ();
        log.info("Out of method :" + name );
    }
}
