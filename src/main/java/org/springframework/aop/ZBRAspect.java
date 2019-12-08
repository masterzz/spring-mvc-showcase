package org.springframework.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ZBRAspect {

    @Pointcut("execution(* org.springframework.aop.dao.*.*(..))")
    public void pointCutExecution() {

    }

    //    within只能定义到类
    @Pointcut("within(org.springframework.aop.dao.*)")
    public void pointCutWithin() {

    }

    @Pointcut("args(java.lang.String)")
    public void pointCutArgs() {

    }


    @Pointcut("@annotation(org.springframework.aop.anno.ZBRAnno)")
    public void pointCutAnno() {

    }

    //    this代表当前对象
    @Pointcut("this(org.springframework.aop.dao.IndexDao)")
    public void pointCutThis() {

    }

    //    target代表目标对象
    @Pointcut("target(org.springframework.aop.dao.IndexDao)")
    public void pointCutTarget() {

    }


    /**
     * location
     * logic
     */
//    @Before("pointCutExecution()")
//    @Before("pointCutWithin()")
//    @Before("pointCutExecution()&&!pointCutArgs()")
//    @Before("pointCutAnno()")
    @Before("pointCutThis()")
    public void before(JoinPoint jp) {
        System.out.println("before");
        System.out.println(jp.getThis());
    }
//
//    @After("pointCutThis()")
//    public void after() {
//        System.out.println("after");
//    }

//    @Around("pointCutThis()")
//    public void around(ProceedingJoinPoint proceedingJoinPoint) {
////        属于哪个类
//        System.out.println("around");
//    }
}
