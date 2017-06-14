/**
 * 
 */
package com.suse.www.mongo.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suse.www.mongo.dao.IUserDao;
import com.suse.www.mongo.entity.User;
import com.suse.www.mongo.service.IUserService;

/**
 * @author Administrator
 *
 */
@Service("userService")
public class UserService implements IUserService {

	@Resource(name="userDao")
	private IUserDao userDao;
	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午10:34:58
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午10:34:58
	 */
	@Override
	public List<User> findList(int skip, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午10:34:58
	 */
	@Override
	public void store(User t) {
		userDao.store(t);
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午10:34:58
	 */
	@Override
	public User findOne(String id) {
		User user = new User();
		user = userDao.findOne(id);
		return user;
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午10:34:58
	 */
	@Override
	public void updateFirst(User t) {
		// TODO Auto-generated method stub

	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午10:34:58
	 */
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
