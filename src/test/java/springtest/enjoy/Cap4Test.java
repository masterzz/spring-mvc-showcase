package springtest.enjoy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ioc.enjoy.cap4.config.Cap4MainConfig;

public class Cap4Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap4MainConfig.class);

		System.out.println("IOC容器创建完成........");
		app.getBean("person");//执行获取的时候才创建并初始化bean

	}
}
