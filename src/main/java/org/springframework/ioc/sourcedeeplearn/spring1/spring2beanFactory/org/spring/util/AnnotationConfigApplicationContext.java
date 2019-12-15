package org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.org.spring.util;


import org.springframework.ioc.sourcedeeplearn.spring1.spring2beanFactory.com.luban.anno.Luban;

import java.io.File;

public class AnnotationConfigApplicationContext {

    public void scan(String basePackage){
        String rootPath = this.getClass().getResource("/").getPath();
        String  basePackagePath =basePackage.replaceAll("\\.","\\\\");
        File file = new File(rootPath+"//"+basePackagePath);
        String names[]=file.list();
        for (String name : names) {
            name=name.replaceAll(".class","");
            try {

               Class clazz =  Class.forName(basePackage+"."+name);
                //判斷是否是屬於@servi@xxxx
                if(clazz.isAnnotationPresent(Luban.class)){
                    Luban luban = (Luban) clazz.getAnnotation(Luban.class);
                    System.out.println(luban.value());
                    System.out.println(clazz.newInstance());

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
