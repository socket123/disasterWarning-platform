package com.yoxnet.role.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import javax.yoxnet.common.exception.BusinessException;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.common.utils.Stringer;
import com.yoxnet.role.bean.SysRole;
import com.yoxnet.role.bean.SysRoleExample;
import com.yoxnet.role.bean.SysRoleExample.Criteria;
import com.yoxnet.role.dao.SysRoleMapper;
import com.yoxnet.role.service.SysRoleService;
import com.yoxnet.user.bean.UserExample;


@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	private final static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

	@Resource
	private SysRoleMapper sysRoleMapper;

	@Override
	public ServiceResult<Object> getByName(String name) {
		try {
			if(Stringer.isNullOrEmpty(name)){
				return null;
			}
			SysRoleExample example = new SysRoleExample();
			Criteria criteria = example.or();
			criteria.andNameEqualTo(name);
			return ServiceTool.buildSuccessResult(sysRoleMapper.selectByExample(example));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void save(SysRole sysRole) {
		if (null == sysRole) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.sysRoleMapper.insertSelective(sysRole);
	}

	@Override
	public void update(SysRole sysRole) {
		if (null == sysRole) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	}

	@Override
	public SysRole getById(String id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysRole> list(SysRole sysRole) {
		return this.list(sysRole, null);
	}

	@Override
	public List<SysRole> list(SysRole sysRole, String orderByStr) {
		SysRoleExample example = new SysRoleExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<SysRole> sysRoleList = this.sysRoleMapper.selectByExample(example);
		return sysRoleList;
	}

	@Override
	public PageResult<SysRole> findPageByParam(SysRole sysRole, PageParam pageParam) {
		return this.findPageByParam(sysRole, pageParam, null);
	}

	@Override
	public PageResult<SysRole> findPageByParam(SysRole sysRole, PageParam pageParam, String orderByStr) {
		PageResult<SysRole> pageResult = new PageResult<SysRole>();

		SysRoleExample example = new SysRoleExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.sysRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SysRole> findSysRoleByTaskName(String taskName) {
		// TODO Auto-generated method stub
		SysRoleExample example = new SysRoleExample();
		
		Criteria criteria = example.createCriteria();

		criteria.andTaskNameEqualTo(taskName);
		
		List<SysRole> sysRoleList = this.sysRoleMapper.selectByExample(example);
		
		return sysRoleList;
	
	}
	
	
	

}
