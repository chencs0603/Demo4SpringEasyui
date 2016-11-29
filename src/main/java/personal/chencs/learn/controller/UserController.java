package personal.chencs.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import personal.chencs.learn.domain.DataGrid;
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
		logger.debug("name:" + name);
		
		User user = userService.queryByName(name);
		model.addAttribute("user", user);
		
		logger.debug(user);
		logger.info("exit action: queryByName");
		
		return "user/show";

	}
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody String query(ModelMap model, int page, int rows){
		logger.info("enter action: query");
		logger.debug("page:" + page + ", row:" + rows);
		
		User user = new User();
		user.setId(1);
		user.setName("chencs");
		user.setPassword("123456");
		user.setAge(27);
		
		List<User> list = new ArrayList<>();
		list.add(user);
		
		DataGrid<User> dataGrid = new DataGrid<>();
		dataGrid.setPage(1);
		dataGrid.setRows(list);

		String json = JSON.toJSONString(dataGrid);
		
		logger.debug("json:" + json);
		logger.info("exit action: query");
		
		return json;
	}
}
