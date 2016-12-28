package personal.chencs.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import personal.chencs.learn.domain.User;
import personal.chencs.learn.test.BasicSpringTest;

public class UserServiceTest extends BasicSpringTest{
	
	@Autowired
	private UserService userService;

	@Test
	public void testAdd() {
		User user = new User();
		user.setName("test");
		user.setPassword("test");
		user.setAge(13);
		
		Assert.assertTrue(userService.add(user));
		
	}

}
