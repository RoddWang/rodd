/**
 * 
 */
package com.suse.www.mongo.service;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface IBaseService<T> {

	List<T> findAll();  

	List<T> findList(int skip, int limit);  

	void store(T t);  

	T findOne(String id);  


	void updateFirst(T t);  

	void delete(String  id); 
}
