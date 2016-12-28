package personal.chencs.learn.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.chencs.learn.dao.UserDao;
import personal.chencs.learn.domain.DataGrid;
import personal.chencs.learn.domain.Pagination;
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
	
	/**
	 * 分页查询
	 * @param pagination
	 * @return
	 */
	public DataGrid<User> queryByPage(Pagination pagination){
		logger.info("enter UserService: queryByPage");
		logger.debug("pageNo:" + pagination.getPageNo() + ", pageSize:" + pagination.getPageSize());
		
		pagination.computeRowRange();
		List<User> userList = userDao.queryByPage(pagination);
		
		int total = userDao.queryCount();
		
		DataGrid<User> dataGrid = new DataGrid<>();
		dataGrid.setTotal(total);
		dataGrid.setRows(userList);
		
		logger.debug("List Size:" + userList.size());
		logger.debug("total:" + total);
		logger.info("exit UserService: queryByPage");
		
		return dataGrid;
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public boolean add(User user) {
		if (null == user) {
			return false;
		}

		try {
			return userDao.add(user);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return false;
		}
	}
}
