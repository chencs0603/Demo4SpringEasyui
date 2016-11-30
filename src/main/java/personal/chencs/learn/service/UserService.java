package personal.chencs.learn.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.chencs.learn.dao.UserDao;
import personal.chencs.learn.domain.User;

/**
 * Service层
 * @author chencs
 *
 */
@Service
public class UserService {
	private static Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 指定name查询
	 * @param name
	 * @return
	 */
	public User queryByName(String name){
		logger.info("enter UserService: queryByName");
		logger.debug("name:" + name);
		
		User user = userDao.queryByName(name);
		
		logger.debug("user:" + user);
		logger.info("exit UserService: queryByName");
		
		return user;
	}
}
