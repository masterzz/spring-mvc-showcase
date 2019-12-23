package springtest.enjoy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ioc.enjoy.cap9.config.Cap9MainConfig;
import org.springframework.ioc.enjoy.cap9.dao.TestDao;
import org.springframework.ioc.enjoy.cap9.service.TestService;

public class Cap9Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);

		TestService testService = app.getBean(TestService.class);
		testService.println();
		//直接从容器中获取TestDao, 和使用Autowired注解来取比较
		TestDao testDao = app.getBean(TestDao.class);
		System.out.println(testDao);

		app.close();





	}
}

