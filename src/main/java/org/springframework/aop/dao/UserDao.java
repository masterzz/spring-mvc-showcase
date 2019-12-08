package org.springframework.aop.dao;

import org.springframework.stereotype.Component;

//@Component
public class UserDao {
    public void query() {
        System.out.println("查到两条用户记录");
    }
}
