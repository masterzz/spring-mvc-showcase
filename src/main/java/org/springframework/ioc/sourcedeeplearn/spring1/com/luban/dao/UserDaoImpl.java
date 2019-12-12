package org.springframework.ioc.sourcedeeplearn.spring1.com.luban.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void query() {
        System.out.println("dao");
    }
}
