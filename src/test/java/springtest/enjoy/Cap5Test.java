package springtest.enjoy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ioc.enjoy.cap5.config.Cap5MainConfig;

public class Cap5Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap5MainConfig.class);

		System.out.println("IOC容器创建完成........");


	}
}

