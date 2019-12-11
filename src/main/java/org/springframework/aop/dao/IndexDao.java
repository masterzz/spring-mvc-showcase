package org.springframework.aop.dao;

import org.springframework.aop.anno.ZBRAnno;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDao implements Dao {
    public void query() {
        System.out.println("query1");
    }

    @ZBRAnno
    public void query(String str) {
        System.out.println("hello"+str);
    }
}
