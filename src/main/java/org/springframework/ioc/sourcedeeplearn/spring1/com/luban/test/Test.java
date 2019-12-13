package org.springframework.ioc.sourcedeeplearn.spring1.com.luban.test;


import org.springframework.ioc.sourcedeeplearn.spring1.com.luban.service.UserService;
import org.springframework.ioc.sourcedeeplearn.spring1.org.spring.util.BeanFactory;

public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");

        UserService service = (UserService) beanFactory.getBean("service");

        service.find();
    }
}
