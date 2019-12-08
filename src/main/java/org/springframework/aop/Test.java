package org.springframework.aop;

import org.springframework.aop.dao.Dao;
import org.springframework.aop.dao.IndexDao;
import org.springframework.aop.dao.UserDao;
import org.springframework.aop.entity.CityEntity;
import org.springframework.aop.util.CommonUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;
import sun.text.resources.iw.FormatData_iw_IL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
//        System.out.println("begin");
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserDao bean = ac.getBean(UserDao.class);
//        bean.query();
//        ac.close();
//        CityEntity cityEntity = new CityEntity();
//        cityEntity.setId("1");
//        cityEntity.setName("test");
//        String sql = CommonUtil.buildQuerySqlForEntity(cityEntity);
//        System.out.println(sql);


        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Dao bean = ac.getBean(IndexDao.class);
        System.out.println(bean instanceof Dao);
        System.out.println(bean instanceof Proxy);
        bean.query();
        bean.query("qqq");

//        Class<?>[] interfaces = new Class[]{Dao.class};
//        byte[] bytes = ProxyGenerator.generateProxyClass("ZBR", interfaces);
//        File file = new File("e:\\Test.class");
////        jdk代理生成的对象，是实现了Dao：
////        public final class ZBR extends Proxy implements Dao {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(bytes);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
