package org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.service;


import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.anno.Luban;
import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.dao.UserDao;

@Luban("AA")
public class UserServiceImpl1 implements UserService {

    
    UserDao dao;

    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }

    //public void setDao(UserDao dao) {
       // this.dao = dao;
   // }
}
