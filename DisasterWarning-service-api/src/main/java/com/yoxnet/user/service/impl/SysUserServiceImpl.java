package com.yoxnet.user.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.github.pagehelper.PageHelper;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import javax.yoxnet.common.exception.BusinessException;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.common.utils.Stringer;
import com.yoxnet.user.bean.User;
import com.yoxnet.user.bean.UserExample;
import com.yoxnet.user.bean.UserExample.Criteria;
import com.yoxnet.user.dao.UserMapper;
import com.yoxnet.user.service.SysUserService;


@Service("UserService")
public class SysUserServiceImpl implements SysUserService {

	private final static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Resource
	private UserMapper UserMapper;


	@Override
	public ServiceResult<Object> getByName(String name) {
		try {
			if(Stringer.isNullOrEmpty(name)){
				return null;
			}
			UserExample example = new UserExample();
			Criteria criteria = example.or();
			criteria.andNameEqualTo(name);
			
			List<User> userList = UserMapper.selectByExample(example);
			if(CollectionUtils.isEmpty(userList)){
				return ServiceTool.buildSuccessResult(null);
			}
			
			return ServiceTool.buildSuccessResult(userList.get(0));
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void save(User User) {
		if (null == User) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.UserMapper.insertSelective(User);
	}

	@Override
	public void update(User User) {
		if (null == User) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.UserMapper.updateByPrimaryKeySelective(User);
	}

	@Override
	public User getById(String id) {
		return UserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> list(User User) {
		return this.list(User, null);
	}

	@Override
	public List<User> list(User User, String orderByStr) {
		UserExample example = new UserExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<User> UserList = this.UserMapper.selectByExample(example);
		return UserList;
	}

	@Override
	public PageResult<User> findPageByParam(User User, PageParam pageParam) {
		return this.findPageByParam(User, pageParam, null);
	}

	@Override
	public PageResult<User> findPageByParam(User User, PageParam pageParam, String orderByStr) {
		PageResult<User> pageResult = new PageResult<User>();

		UserExample example = new UserExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<User> list = UserMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.UserMapper.deleteByPrimaryKey(id);
	}

}
