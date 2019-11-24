package org.springframework.aop;

import org.springframework.aop.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        System.out.println("begin");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDao bean = ac.getBean(UserDao.class);
        bean.query();
        ac.close();
    }
}
