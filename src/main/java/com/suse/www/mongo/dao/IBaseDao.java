/**
 * 
 */
package com.suse.www.mongo.dao;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface IBaseDao<T> {

    List<T> findAll();  
  
    List<T> findList(int skip, int limit);  
  
    void store(T t);  
  
    T findOne(String id);  
  
   
    void updateFirst(T t);  
  
    void delete(String  id);  
}
