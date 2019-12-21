package org.springframework.enjoy.cap1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.enjoy.cap1.Person;

//������====�����ļ�
@Configuration
public class MainConfig {
	//��������ע��һ��bean, ����Ϊ����ֵ������, 
	@Bean("abcPerson")
	public Person person01(){
		return new Person("james",20);
	}
}
