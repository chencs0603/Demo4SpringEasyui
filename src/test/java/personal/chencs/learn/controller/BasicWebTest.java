package personal.chencs.learn.controller;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.context.WebApplicationContext;

@SuppressWarnings("deprecation")
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class BasicWebTest extends AbstractTransactionalJUnit4SpringContextTests {

	static {
		try {
			Log4jConfigurer.initLogging("classpath:properties/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}
	
	//注入web环境的ApplicationContext容器
	@Autowired
	protected WebApplicationContext webAppContext;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setUp() {
		// 指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

}
