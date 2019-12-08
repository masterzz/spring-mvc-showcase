package org.springframework.aop;

import org.springframework.aop.dao.UserDao;
import org.springframework.aop.entity.CityEntity;
import org.springframework.aop.util.CommonUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
//        System.out.println("begin");
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserDao bean = ac.getBean(UserDao.class);
//        bean.query();
//        ac.close();
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        String sql = CommonUtil.buildQuerySqlForEntity(cityEntity);
        System.out.println(sql);

    }
}
