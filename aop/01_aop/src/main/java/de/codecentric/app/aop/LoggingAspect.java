package de.codecentric.app.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // TODO
    public void logBefore(JoinPoint joinPoint) {
        log.info("Method called: {}", joinPoint.getSignature().getName());
    }

    // TODO
    public void logAfter(JoinPoint joinPoint) {
        log.info("Method finished: {}", joinPoint.getSignature().getName());
    }

    // TODO
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long executionTime = 0;
        log.info("{} executed in: {} ms", joinPoint.getSignature(), executionTime);
        return null;
    }

    // TODO
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
    }
}
