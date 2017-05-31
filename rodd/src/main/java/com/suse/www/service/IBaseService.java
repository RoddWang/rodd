package com.suse.www.service;

import java.util.List;

public interface IBaseService<T>  {

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
