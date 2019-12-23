package org.springframework.ioc.enjoy.cap6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class JamesImportSelector implements ImportSelector{
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata){
		//返回全类名的bean
		return new String[]{"org.springframework.enjoy.cap6.bean.Fish","org.springframework.enjoy.cap6.bean.Tiger"};
	}
}
