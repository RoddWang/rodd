/**
 * 
 */
package com.suse.www.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suse.www.entity.TFoodName;
import com.suse.www.mapper.TFoodNameMapper;
import com.suse.www.service.ITFoodNameService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Service
public class TFoodNameService implements ITFoodNameService {

	@Resource
	private TFoodNameMapper tFoodNameMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		int total = 0;
		total = tFoodNameMapper.deleteByPrimaryKey(id);
		return total;
	}

	@Override
	public int deleteByObejct(TFoodName t) {
		int total = 0;
		total = tFoodNameMapper.deleteByObejct(t);
		return total;
	}

	@Override
	public int insert(TFoodName t) {
		int total = 0;
		total = tFoodNameMapper.insert(t);
		return total;
	}

	@Override
	public int insertSelective(TFoodName t) {
		int total = 0;
		total = tFoodNameMapper.insertSelective(t);
		return total;
	}

	@Override
	public TFoodName selectByPrimaryKey(Integer id) {
		TFoodName tFoodName = new TFoodName();
		tFoodName = tFoodNameMapper.selectByPrimaryKey(id);
		return tFoodName;
	}

	@Override
	public TFoodName selectByObject(TFoodName t) {
		TFoodName tFoodName = new TFoodName();
		tFoodName = tFoodNameMapper.selectByObject(t);
		return tFoodName;
	}

	@Override
	public List<TFoodName> selectAll(TFoodName t) {
		List<TFoodName> tFoodNameList = new ArrayList<TFoodName>();
		tFoodNameList = tFoodNameMapper.selectAll(t);
		return tFoodNameList;
	}

	@Override
	public int updateByPrimaryKeySelective(TFoodName t) {
		int total = 0;
		total = tFoodNameMapper.updateByPrimaryKeySelective(t);
		return total;
	}

	@Override
	public int updateByPrimaryKey(TFoodName t) {
		int total = 0;
		total = tFoodNameMapper.updateByPrimaryKey(t);
		return total;
	}

	@Override
	public int count(TFoodName t) {
		int total = 0;
		total = tFoodNameMapper.count(t);
		return total;
	}

	@Override
	public int getId() {
		int id = tFoodNameMapper.getId();
		return id;
	}

}
