package org.springframework.ioc.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/5 12:47 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
@Configuration
@ComponentScan
//这个注释可以加载xml文件
@Service
@ImportResource
public class Test {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:aaa.xml");
//        IndexService service = (IndexService) classPathXmlApplicationContext.getBean("service");
//        注解采用的类：
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexService service = annotationConfigApplicationContext.getBean(IndexService.class);
        IndexService service1 = annotationConfigApplicationContext.getBean(IndexService.class);
//        service.service();
//        System.out.println(service);
//        System.out.println(service1);
        service.service();
        service.service();
        service.service();
    }
}
