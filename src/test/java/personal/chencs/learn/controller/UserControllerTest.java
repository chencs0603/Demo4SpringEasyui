package personal.chencs.learn.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class UserControllerTest extends BasicWebTest{

	@Test
	public void testAdd() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/user/add")
				.param("name", "test")
				.param("password", "test")
				.param("age", "12")
				)
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("success"));
	}
}
