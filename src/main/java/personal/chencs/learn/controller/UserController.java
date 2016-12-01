package personal.chencs.learn.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import personal.chencs.learn.domain.DataGrid;
import personal.chencs.learn.domain.Pagination;
import personal.chencs.learn.domain.User;
import personal.chencs.learn.service.UserService;

@Controller
@RequestMapping(value = "user", produces="application/json;charset=UTF-8")//若produces上配置json，则必须加上charset=UTF-8，否则还是会出现中文乱码,放在controller类上对该类的所有方法都起作用，但可以被方法上的配置覆盖
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	// 指定name查询
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
	
	// 分页查询
	@RequestMapping(value = "/queryByPage", method = RequestMethod.GET)
	public @ResponseBody String queryByPage(ModelMap model, @RequestParam(value="page", required=true, defaultValue="1") int pageNo, 
															@RequestParam(value="rows", required=true, defaultValue="10") int pageSize){
		logger.info("enter action: query");
		logger.debug("page:" + pageNo + ", row:" + pageSize);

		Pagination pagination = new Pagination(pageNo, pageSize);
		DataGrid<User> dataGrid = userService.queryByPage(pagination);
		
		String json = JSON.toJSONString(dataGrid);
		
		logger.debug("json:" + json);
		logger.info("exit action: query");
		
		return json;
	}
}
