package org.springframework.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = false)
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableAspectJAutoProxy
//@ComponentScan("org.springframework.aop")
@ImportResource("classpath:aaa.xml")
public class AppConfig {
}