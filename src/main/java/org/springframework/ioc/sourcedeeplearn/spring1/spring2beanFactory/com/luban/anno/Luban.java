package org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Luban {
    public String value();
}
