package springtest.enjoy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ioc.enjoy.cap2.config.Cap2MainConfig;
import org.springframework.ioc.enjoy.cap2.controller.OrderController;


public class Cap2Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap2MainConfig.class);
		app.getBean(OrderController.class);
		
		String[] names = app.getBeanDefinitionNames();
		System.out.println("----------------------------");
		for(String name:names){
			System.out.println(name);
		}
	}
}
