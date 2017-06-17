package com.yoxnet.task.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.yoxnet.common.utils.DateUtiler;
import com.yoxnet.common.utils.Stringer;
import com.yoxnet.role.bean.SysRole;
import com.yoxnet.role.service.SysRoleService;
import com.yoxnet.task.service.SysTaskService;
import com.yoxnet.task.bean.SysTask;
import com.yoxnet.task.bean.SysTaskExample;
import com.yoxnet.task.bean.SysTaskExample.Criteria;
import com.yoxnet.task.dao.SysTaskMapper;


@Service("sysTaskService")
public class SysTaskServiceImpl implements SysTaskService {

	private final static Logger logger = LoggerFactory.getLogger(SysTaskServiceImpl.class);

	@Resource
	private SysTaskMapper sysTaskMapper;

	@Resource
	private SysRoleService sysRoleService;
	
	@Override
	public ServiceResult<Object> getByName(String name) {
		try {
			if(Stringer.isNullOrEmpty(name)){
				return null;
			}
			SysTaskExample example = new SysTaskExample();
			Criteria criteria = example.or();
			criteria.andTaskNameEqualTo(name);
			return ServiceTool.buildSuccessResult(sysTaskMapper.selectByExample(example));
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public ServiceResult<Object> getTaskList(String name,String time){
		try {
			if(null == name){
				return ServiceTool.buildApplicationFailResult("用户名称不可为空");
			}
			
			List<SysRole> roleList = (List<SysRole>) sysRoleService.getByName(name).getResult();
			
			List<String> list = new ArrayList<String>();
			
			for(SysRole role:roleList){
				list.add(role.getTaskName());
			}
			
			SysTaskExample example = new SysTaskExample();
			Criteria criteria = example.or();
			criteria.andTaskNameIn(list);
			
			if(StringUtils.isEmpty(time)){
				time = DateUtiler.getNow();
			}
			
			criteria.andStartTimeLessThan(time);
			criteria.andEndTimeGreaterThan(time);
			return ServiceTool.buildSuccessResult(sysTaskMapper.selectByExample(example));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	};
	
	@Override
	public void save(SysTask sysTask) {
		if (null == sysTask) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.sysTaskMapper.insertSelective(sysTask);
	}

	@Override
	public void update(SysTask sysTask) {
		if (null == sysTask) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.sysTaskMapper.updateByPrimaryKeySelective(sysTask);
	}

	@Override
	public SysTask getById(String id) {
		return sysTaskMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysTask> list(SysTask sysTask) {
		return this.list(sysTask, null);
	}

	@Override
	public List<SysTask> list(SysTask sysTask, String orderByStr) {
		SysTaskExample example = new SysTaskExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<SysTask> sysTaskList = this.sysTaskMapper.selectByExample(example);
		return sysTaskList;
	}

	@Override
	public PageResult<SysTask> findPageByParam(SysTask sysTask, PageParam pageParam) {
		return this.findPageByParam(sysTask, pageParam, null);
	}

	@Override
	public PageResult<SysTask> findPageByParam(SysTask sysTask, PageParam pageParam, String orderByStr) {
		PageResult<SysTask> pageResult = new PageResult<SysTask>();

		SysTaskExample example = new SysTaskExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<SysTask> list = sysTaskMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.sysTaskMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SysTask> validTask() {
		// TODO Auto-generated method stub
		
		SysTaskExample example = new SysTaskExample();
		
		example.createCriteria().andEndTimeGreaterThanOrEqualTo(DateUtiler.getNow());
		
		return sysTaskMapper.selectByExample(example);
	}

	
	
}
