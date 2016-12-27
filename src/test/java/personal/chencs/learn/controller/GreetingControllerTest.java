package personal.chencs.learn.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//XML风格
@RunWith(JUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
//指定容器层次
@ContextHierarchy({  
        @ContextConfiguration(name = "parent", locations = "classpath:spring/applicationContext.xml"),  
        @ContextConfiguration(name = "child", locations = "classpath:spring/spring-mvc.xml")  
}) 
public class GreetingControllerTest {
	
	//注入web环境的ApplicationContext容器
	@Autowired  
    private WebApplicationContext webAppContext;  
    private MockMvc mockMvc;  
  
    @Before  
    public void setUp() {  
    	//指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build(); 
    }  

    @Test  
    public void testPrintHello() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))     //perform执行一个请求,MockMvcRequestBuilders.get(构造一个请求
                .andExpect(MockMvcResultMatchers.view().name("greeting"))  				//andExpect添加验证断言来判断执行请求后的结果是否是预期的，MockMvcResultMatchers.view()得到视图验证器
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))   	//MockMvcResultMatchers.model()得到模型验证器
                .andDo(MockMvcResultHandlers.print())  									//ResultActions.andDo添加一个结果处理器，表示要对结果做相关处理，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
                .andReturn();  															//ResultActions.andReturn表示执行完成后返回相应的结果
          
        Assert.assertTrue("Hello Spring MVC Framework!".equals(result.getModelAndView().getModel().get("message")));  
    } 
}
