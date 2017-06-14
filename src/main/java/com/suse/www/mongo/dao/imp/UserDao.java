/**
 * 
 */
package com.suse.www.mongo.dao.imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.suse.www.mongo.dao.IUserDao;
import com.suse.www.mongo.entity.User;

/**
 * @author Administrator
 *
 */
@Repository("userDao")
public class UserDao implements IUserDao {
 
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private final String collectionName = "user";
	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午9:58:51
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
	 * 2017年6月14日  下午9:58:51
	 */
	@Override
	public List<User> findList(int skip, int limit) {
		return null;
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午9:58:51
	 */
	@Override
	public void store(User t) {
		
		this.mongoTemplate.save(t, collectionName);
		
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午9:58:51
	 */
	@Override
	public User findOne(String id) {
		Query query = new Query();
		query.addCriteria(new Criteria("id").is(id));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午9:58:51
	 */
	@Override
	public void updateFirst(User t) {
		Query query = new Query();
		query.addCriteria(new Criteria("id").is(t.getId()));
		Update update = new Update();
		update.set("",t.getUsername());
		update.set("", t.getPassword());
	    mongoTemplate.updateFirst(query, update, User.class);
	}

	/** 
	 * @param </br>
	 * @param </br>
	 * @return </br>
	 * TODO </br>
	 * 2017年6月14日  下午9:58:51
	 */
	@Override
	public void delete(String id) {
		Query query = new Query();
		query.addCriteria(new Criteria("id").is(id));
		this.mongoTemplate.remove(query, User.class);
		
	}
	

}
