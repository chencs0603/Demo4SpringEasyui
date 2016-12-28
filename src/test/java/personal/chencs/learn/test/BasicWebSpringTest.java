package personal.chencs.learn.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration(value = "src/main/webapp")
public class BasicWebSpringTest extends BasicSpringTest {
	
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
