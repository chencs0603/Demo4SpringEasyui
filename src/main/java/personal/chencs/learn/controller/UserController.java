package personal.chencs.learn.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import personal.chencs.learn.domain.User;
import personal.chencs.learn.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/queryByName", method = RequestMethod.POST)
	public String queryByName(ModelMap model, String name){
		logger.info("enter action: queryByName");
		logger.info("name:" + name);
		
		User user = userService.queryByName(name);
		model.addAttribute("user", user);
		
		logger.info("exit action: queryByName");
		
		return "user/show";

	}
}
