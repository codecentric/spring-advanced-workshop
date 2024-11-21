package de.codecentric.app.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Lösung 1.2
    @Before("execution(* de.codecentric.app..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Method called: {}", joinPoint.getSignature().getName());
    }

    // Lösung 1.3
    @After("execution(* de.codecentric.app..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Method finished: {}", joinPoint.getSignature().getName());
    }

    // Lösung 1.4
    @Around("execution(* de.codecentric.app.service.FarmService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("{} executed in: {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }

    // Lösung Bonus
    @AfterThrowing(pointcut = "execution(* de.codecentric.app.service..*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.error("Exception in method: {} with cause: {}", joinPoint.getSignature().getName(), error.getMessage());
    }
}
