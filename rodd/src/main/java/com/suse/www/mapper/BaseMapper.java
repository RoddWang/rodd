/**
 * 
 */
package com.suse.www.mapper;

import java.util.List;


/**
 * @author Rodd.Wang
 *
 */
public interface BaseMapper<T> {

	 	int deleteByPrimaryKey(Integer id);

	 	int deleteByObejct(T t);
	 	
	    int insert(T t);

	    int insertSelective(T t);

	    T selectByPrimaryKey(Integer id);

	    T selectByObject(T t);
	    
	    List<T> selectAll(T t);
	    
	    int updateByPrimaryKeySelective(T t);

	    int updateByPrimaryKey(T t);
	    
	    int count(T t);
	    
	    int getId();
}
