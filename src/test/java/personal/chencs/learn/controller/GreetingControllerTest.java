package personal.chencs.learn.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GreetingControllerTest extends BasicWebTest{
	
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
