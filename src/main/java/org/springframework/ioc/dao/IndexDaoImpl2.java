package org.springframework.ioc.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Lazy()
@Repository
public class IndexDaoImpl2 implements IndexDao {
    @Override
    public void test1() {

    }

    @PostConstruct
    public void init() {
        System.out.println("init IndexDaoImpl2");
    }
}
