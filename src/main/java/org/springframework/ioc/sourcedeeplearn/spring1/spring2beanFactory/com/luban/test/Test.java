package org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.test;


import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.service.UserService;
import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.org.spring.util.AnnotationConfigApplicationContext;
import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.org.spring.util.BeanFactory;

public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring_beanfactory.xml");

        UserService service = (UserService) beanFactory.getBean("service");

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new
//                AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.scan("com.luban.service");

        service.find();
    }
}
