package org.springframework.aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//元注解，type表示能出现在类上
@Target({ElementType.TYPE,ElementType.FIELD })
//如果是SOURCE则表明只存在于源代码中，CLASS表明存在于class文件中，
//要做到运行时还能获取，则用RUNTIME
//@Retention(RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
    public String value() default "";
}
