package org.springframework.ioc.enjoy.cap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.ioc.enjoy.cap1.Person;


@Configuration
//@Controller  @Service  @Respostry  @Component
@ComponentScan(value="org.springframework.ioc.enjoy.cap2", includeFilters={
		@Filter(type=FilterType.CUSTOM, classes={JamesTypeFilter.class})
}, useDefaultFilters=true)
public class Cap2MainConfig {
	//给容器中注册一个bean, 类型为返回值的类型,
	@Bean
	public Person person01(){
		return new Person("james",20);
	}
}

