package org.springframework.ioc.dao.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
//可以同时实现几个，如果要改变顺序，再用PriorityOrdered
public class TestBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("indexService")) {
            System.out.println("postProcessBeforeInitialization");
        }
        /**
         *
         */
//        Proxy.newProxyInstance() 这样就可以做一个代理
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("indexService")) {
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }

    @Override
//    值越小，越先
    public int getOrder() {
        return 0;
    }
}
