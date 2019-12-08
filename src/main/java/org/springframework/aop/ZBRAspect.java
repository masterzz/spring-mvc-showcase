package org.springframework.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
    public void before() {
        System.out.println("before");
    }
}
