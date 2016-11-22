package personal.chencs.learn.service;

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
	
	@Autowired
	private UserDao userDao;
	
	public User queryByName(String name){
		return userDao.queryByName(name);
	}
}
