package org.springframework.ioc.enjoy.cap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.ioc.enjoy.cap1.Person;


@Configuration
@ComponentScan(value="org.springframework.ioc.enjoy.cap2", includeFilters={
		@Filter(type=FilterType.CUSTOM, classes={JamesTypeFilter.class})
}, useDefaultFilters=false)


public class Cap2MainConfig {
	//��������ע��һ��bean, ����Ϊ����ֵ������, 
	@Bean
	public Person person01(){
		return new Person("james",20);
	}
}
