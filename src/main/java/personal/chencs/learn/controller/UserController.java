package personal.chencs.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import personal.chencs.learn.domain.User;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping(value = "/queryByName", method = RequestMethod.GET)
	public String queryByName(ModelMap model, String name){
		System.out.println("input:" + name);
		
		User user = new User();
		user.setId(1);
		user.setName(name);
		user.setPassword("12345678");
		user.setAge(27);
		model.addAttribute("user", user);
		
		return "user/show";
	}
}
