package org.springframework.log;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Service;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/11/26 17:24 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexService bean = ac.getBean(IndexService.class);
        bean.index();
    }
}
