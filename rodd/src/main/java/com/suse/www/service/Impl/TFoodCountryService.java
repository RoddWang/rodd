/**
 * 
 */
package com.suse.www.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suse.www.entity.TFoodCountry;
import com.suse.www.mapper.TFoodCountryMapper;
import com.suse.www.service.ITFoodCountryService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Service
public class TFoodCountryService implements ITFoodCountryService {

	@Resource
	private TFoodCountryMapper tFoodCountryMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		int total = 0;
		total = tFoodCountryMapper.deleteByPrimaryKey(id);
		return total;
	}

	@Override
	public int deleteByObejct(TFoodCountry t) {
		int total = 0;
		total = tFoodCountryMapper.deleteByObejct(t);
		return total;
	}

	@Override
	public int insert(TFoodCountry t) {
		int total = 0;
		total = tFoodCountryMapper.insert(t);
		return total;
	}

	@Override
	public int insertSelective(TFoodCountry t) {
		int total = 0;
		total = tFoodCountryMapper.insertSelective(t);
		return total;
	}

	@Override
	public TFoodCountry selectByPrimaryKey(Integer id) {
		TFoodCountry tFoodCountry = new TFoodCountry();
		tFoodCountry = tFoodCountryMapper.selectByPrimaryKey(id);
		return tFoodCountry;
	}

	@Override
	public TFoodCountry selectByObject(TFoodCountry t) {
		TFoodCountry tFoodCountry = new TFoodCountry();
		tFoodCountry = tFoodCountryMapper.selectByObject(t);
		return tFoodCountry;
	}

	@Override
	public List<TFoodCountry> selectAll(TFoodCountry t) {
		List<TFoodCountry> tFoodCountryList = new ArrayList<TFoodCountry>();
		tFoodCountryList = tFoodCountryMapper.selectAll(t);
		return tFoodCountryList;
	}

	@Override
	public int updateByPrimaryKeySelective(TFoodCountry t) {
		int total = 0;
		total = tFoodCountryMapper.updateByPrimaryKeySelective(t);
		return total;
	}

	@Override
	public int updateByPrimaryKey(TFoodCountry t) {
		int total = 0;
		total = tFoodCountryMapper.updateByPrimaryKey(t);
		return total;
	}

	@Override
	public int count(TFoodCountry t) {
		int total = 0;
		total = tFoodCountryMapper.count(t);
		return total;
	}

	@Override
	public int getId() {
		int id = tFoodCountryMapper.getId();
		return id;
	}

}
