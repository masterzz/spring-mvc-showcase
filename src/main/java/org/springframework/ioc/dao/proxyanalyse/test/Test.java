package org.springframework.ioc.dao.proxyanalyse.test;


import org.springframework.ioc.dao.proxyanalyse.dao.LubanDao;
import org.springframework.ioc.dao.proxyanalyse.dao.LubanDaoImpl;
import org.springframework.ioc.dao.proxyanalyse.proxy.ProxyUtil;

public class Test {
    public static void main(String[] args) {

        LubanDao proxy = (LubanDao) ProxyUtil.newInstance(new LubanDaoImpl());
        proxy.query();

    }
}
