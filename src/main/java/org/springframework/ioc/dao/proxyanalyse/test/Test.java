package org.springframework.ioc.dao.proxyanalyse.test;


import org.springframework.ioc.dao.proxyanalyse.dao.LubanDao;
import org.springframework.ioc.dao.proxyanalyse.dao.LubanDaoImpl;
import org.springframework.ioc.dao.proxyanalyse.proxy.ProxyUtil;
import org.springframework.ioc.dao.proxyanalyse.zbr.ZBRProxy;
import org.springframework.ioc.dao.proxyanalyse.zbr.ZBRProxy1;

public class Test {
    public static void main(String[] args) {

//        LubanDao proxy = (LubanDao) ProxyUtil.newInstance(new LubanDaoImpl());
//        proxy.query();
//
//        System.out.println("--------------------------");
//        LubanDao proxy1 = (LubanDao)ZBRProxy.newInstance(new LubanDaoImpl());
//        proxy1.query();
//
//        System.out.println("--------------------------");
        LubanDao proxy2 = (LubanDao) ZBRProxy1.newInstance(new LubanDaoImpl());
        proxy2.query();
    }
}
