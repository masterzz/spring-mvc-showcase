package org.springframework.ioc.enjoy.cap9.service;

import org.springframework.ioc.enjoy.cap9.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TestService {
	//@Qualifier("testDao")
//	@Autowired(required=false)
	//效果是一样的,与Autowired一样可以装配bean
	//1,不支持Primary功能
	//2,不支持Autowired false
	//@Resource(name="testDao2")
	@Inject
	private TestDao testDao;

	public void println(){
		System.out.println(testDao);
	}
}
