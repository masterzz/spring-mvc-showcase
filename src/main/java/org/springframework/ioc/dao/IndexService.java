package org.springframework.ioc.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/5 9:01 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
@Service
//@Scope("prototype")
public class IndexService /*implements ApplicationContextAware*/ {
    @Autowired
//    @Qualifier("indexDaoImpl")
    @Qualifier("indexDaoImpl1")
    private IndexDao dao;

//    private ApplicationContext applicationContext;

    public void service() {
//        dao.test1();
//        dao = (IndexDao) applicationContext.getBean("dao");
        System.out.println("this.hashcode:" + this.hashCode());
        System.out.println(dao.hashCode());
        System.out.println(getDao().hashCode());
    }

//    @Lookup
    public IndexDao getDao() {
        return dao;
    }


    public void setDao(IndexDao dao) {
        this.dao = dao;
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
}
