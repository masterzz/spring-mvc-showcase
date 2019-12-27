package org.springframework.ioc.enjoy.cap12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ioc.enjoy.cap9.bean.Moon;

@Configuration
@ComponentScan("org.springframework.ioc.enjoy.cap12.processor")
public class Cap12MainConfig {
	@Bean
	public Moon getMoon(){
		return new Moon();
	}
}
