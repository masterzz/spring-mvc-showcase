package org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.test;


import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.org.spring.util.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
//        BeanFactory beanFactory = new BeanFactory("spring.xml");
//
//        UserService service = (UserService) beanFactory.getBean("service");

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new
                AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.luban.service");

       // service.find();
    }
}
