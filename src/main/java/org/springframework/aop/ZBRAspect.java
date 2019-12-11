package org.springframework.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.dao.Dao;
import org.springframework.aop.dao.IndexDao;
import org.springframework.aop.dao.TestDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//切面也是单例的；加了如下两项即可形成非单例模式的aspect
@Aspect("perthis(pointCutExecution())")
@Scope("prototype")
public class ZBRAspect {
//    下面这东西能实现扩展！5.4.5 Introductions
    @DeclareParents(value="org.springframework.aop.dao.*", defaultImpl= IndexDao.class)
    public static Dao dao;

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
//    @Before("pointCutThis()")
//    public void before(JoinPoint jp) {
//        System.out.println("before");
//        System.out.println(jp.getThis());
//        System.out.println(jp.getTarget());
//    }
//
//    @After("pointCutThis()")
//    public void after() {
//        System.out.println("after");
//    }

    @Around("pointCutExecution()")
    public void around(ProceedingJoinPoint pjp) {
//        属于哪个类
        System.out.println("around");
        Object[] args = pjp.getArgs();
        System.out.println(args);
        System.out.println("aspect:" + this);
        if(args != null && args.length > 0) {
            for (Object arg : args) {
                arg += " world";
            }
        }
        try {
//            调用方法
            pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around end");
    }
}
