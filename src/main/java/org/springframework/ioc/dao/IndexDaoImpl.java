package org.springframework.ioc.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/5 9:00 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
@Repository("dao")
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test1() {
        System.out.println("impl");
    }
}
