package org.springframework.ioc.sourcedeeplearn.spring1.com.luban.service;


import org.springframework.ioc.sourcedeeplearn.spring1.com.luban.dao.UserDao;

public class UserServiceImpl implements UserService {

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
