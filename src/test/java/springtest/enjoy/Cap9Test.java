package springtest.enjoy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ioc.enjoy.cap9.bean.Moon;
import org.springframework.ioc.enjoy.cap9.bean.Sun;
import org.springframework.ioc.enjoy.cap9.config.Cap9MainConfig;

public class Cap9Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);
//		System.out.println(app);
		
		//TestService testService = app.getBean(TestService.class);
		//testService.println();
		//直接从容器中获取TestDao, 和使用Autowired注解来取比较
		//TestDao testDao = app.getBean(TestDao.class);
		//System.out.println(testDao);
		
		Moon moon = (Moon)app.getBean(Moon.class);
		System.out.println(moon);
		
		

		Sun sun = (Sun)app.getBean(Sun.class);
		System.out.println(sun.getMoon());
		app.close();
		
		
		
		
		
	}
}
