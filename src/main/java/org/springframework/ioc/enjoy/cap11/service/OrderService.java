package org.springframework.ioc.enjoy.cap11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ioc.enjoy.cap11.dao.OrderDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
	private OrderDao orderDao;
//    @Transactional
    public void addOrder(){
    	orderDao.insert();
    	System.out.println("操作完成.........");
    	
    	int a = 1/0;
    }
}
