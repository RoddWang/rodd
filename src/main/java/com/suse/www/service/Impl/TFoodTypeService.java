/**
 * 
 */
package com.suse.www.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suse.www.entity.TFoodType;
import com.suse.www.mapper.TFoodTypeMapper;
import com.suse.www.service.ITFoodTypeService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Service
public class TFoodTypeService implements ITFoodTypeService {

	@Resource
	private TFoodTypeMapper tFoodTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		int total = 0;
		total = tFoodTypeMapper.deleteByPrimaryKey(id);
		return total;
	}

	@Override
	public int deleteByObejct(TFoodType t) {
		int total = 0;
		total = tFoodTypeMapper.deleteByObejct(t);
		return total;
	}

	@Override
	public int insert(TFoodType t) {
		int total = 0;
		total = tFoodTypeMapper.insert(t);
		return total;
	}

	@Override
	public int insertSelective(TFoodType t) {
		int total = 0;
		total = tFoodTypeMapper.insertSelective(t);
		return total;
	}

	@Override
	public TFoodType selectByPrimaryKey(Integer id) {
		TFoodType tFoodType = new TFoodType();
		tFoodType = tFoodTypeMapper.selectByPrimaryKey(id);
		return tFoodType;
	}

	@Override
	public TFoodType selectByObject(TFoodType t) {
		TFoodType tFoodType = new TFoodType();
		tFoodType = tFoodTypeMapper.selectByObject(t);
		return tFoodType;
	}

	@Override
	public List<TFoodType> selectAll(TFoodType t) {

		List<TFoodType> tFoodTypeList = new ArrayList<TFoodType>();
		tFoodTypeList = tFoodTypeMapper.selectAll(t);
		return tFoodTypeList;
	}

	@Override
	public int updateByPrimaryKeySelective(TFoodType t) {
		int total = 0;
		total = tFoodTypeMapper.updateByPrimaryKeySelective(t);
		return total;
	}

	@Override
	public int updateByPrimaryKey(TFoodType t) {
		int total = 0;
		total = tFoodTypeMapper.updateByPrimaryKey(t);
		return total;
	}

	@Override
	public int count(TFoodType t) {
		int total = 0;
		total = tFoodTypeMapper.count(t);
		return total;
	}

	@Override
	public int getId() {
		int id = tFoodTypeMapper.getId();
		return id;
	}



}
