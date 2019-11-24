package org.springframework.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotVeryUsefulAspect {
    @Pointcut(" execution(* org.springframework.aop.dao..*.*(..))")
    private void anyOldTransfer(){}

    @Before("anyOldTransfer()")
    public void advice() {
        System.out.println("--------Before--------------");
    }
}