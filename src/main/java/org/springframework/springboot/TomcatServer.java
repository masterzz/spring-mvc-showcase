package org.springframework.springboot;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);

        tomcat.addWebapp("/", "E:\\Gitspace\\github\\spring-mvc-showcase");
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
