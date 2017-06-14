/**
 * 
 */
package com.suse.www.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suse.www.entity.TUser;
import com.suse.www.mapper.TUserMapper;
import com.suse.www.service.ITUserService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Service
public class TUserService implements ITUserService {

	@Resource
	private TUserMapper tUserMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		int total = 0;
		total += tUserMapper.deleteByPrimaryKey(id);
		return total;
	}

	@Override
	public int deleteByObejct(TUser t) {
		int total = 0;
		total += tUserMapper.deleteByObejct(t);
		return total;
	}

	@Override
	public int insert(TUser t) {
		int total = 0;
		total += tUserMapper.insert(t);
		return total;
	}

	@Override
	public int insertSelective(TUser t) {
		int total = 0;
		total += tUserMapper.insertSelective(t);
		return total;
	}

	@Override
	public TUser selectByPrimaryKey(Integer id) {
		TUser tUser = new TUser();
		tUser = tUserMapper.selectByPrimaryKey(id);
		return tUser;
	}

	@Override
	public TUser selectByObject(TUser t) {
		TUser tUser = new TUser();
		tUser = tUserMapper.selectByObject(t);
		return tUser;
	}

	@Override
	public List<TUser> selectAll(TUser t) {
		List<TUser> tUserList = new ArrayList<TUser>();
		tUserList = tUserMapper.selectAll(t);
		return tUserList;
	}

	@Override
	public int updateByPrimaryKeySelective(TUser t) {
		int total = 0;
		total = tUserMapper.updateByPrimaryKeySelective(t);
		return total;
	}

	@Override
	public int updateByPrimaryKey(TUser t) {
		int total = 0;
		total = tUserMapper.updateByPrimaryKey(t);
		return total;
	}

	@Override
	public int count(TUser t) {
		int total = 0;
		total = tUserMapper.count(t);
		return total;
	}

	@Override
	public int getId() {
		int id = tUserMapper.getId();
		return id;
	}

}
