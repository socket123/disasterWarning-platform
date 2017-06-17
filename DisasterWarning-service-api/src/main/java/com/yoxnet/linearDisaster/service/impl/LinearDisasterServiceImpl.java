package com.yoxnet.linearDisaster.service.impl;

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
import com.yoxnet.linearDisaster.service.LinearDisasterService;
import com.yoxnet.linearDisaster.bean.LinearDisaster;
import com.yoxnet.linearDisaster.bean.LinearDisasterExample;
import com.yoxnet.linearDisaster.bean.LinearDisasterExample.Criteria;
import com.yoxnet.linearDisaster.dao.LinearDisasterMapper;


@Service("linearDisasterService")
public class LinearDisasterServiceImpl implements LinearDisasterService {

	private final static Logger logger = LoggerFactory.getLogger(LinearDisasterServiceImpl.class);

	@Resource
	private LinearDisasterMapper linearDisasterMapper;
	
	
	@Override
	public ServiceResult<Object> getByLinearDisaster(String taskName,String StartTime) {
		try {
			if(null == taskName){
				return ServiceTool.buildApplicationFailResult("任务名称不可为空");
			}
			LinearDisasterExample example = new LinearDisasterExample();
			Criteria criteria = example.or();
			criteria.andTaskNameEqualTo(taskName);
			if(StringUtils.isNotEmpty(StartTime)){
				criteria.andStartTimeLessThan(StartTime);
				criteria.andEndTimeGreaterThan(StartTime);
			}
			return ServiceTool.buildSuccessResult(linearDisasterMapper.selectByExample(example));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}

	@Override
	public void save(LinearDisaster linearDisaster) {
		if (null == linearDisaster) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.linearDisasterMapper.insertSelective(linearDisaster);
	}

	@Override
	public void update(LinearDisaster linearDisaster) {
		if (null == linearDisaster) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.linearDisasterMapper.updateByPrimaryKeySelective(linearDisaster);
	}

	@Override
	public LinearDisaster getById(String id) {
		return linearDisasterMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LinearDisaster> list(LinearDisaster linearDisaster) {
		return this.list(linearDisaster, null);
	}

	@Override
	public List<LinearDisaster> list(LinearDisaster linearDisaster, String orderByStr) {
		LinearDisasterExample example = new LinearDisasterExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<LinearDisaster> linearDisasterList = this.linearDisasterMapper.selectByExample(example);
		return linearDisasterList;
	}

	@Override
	public PageResult<LinearDisaster> findPageByParam(LinearDisaster linearDisaster, PageParam pageParam) {
		return this.findPageByParam(linearDisaster, pageParam, null);
	}

	@Override
	public PageResult<LinearDisaster> findPageByParam(LinearDisaster linearDisaster, PageParam pageParam, String orderByStr) {
		PageResult<LinearDisaster> pageResult = new PageResult<LinearDisaster>();

		LinearDisasterExample example = new LinearDisasterExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<LinearDisaster> list = linearDisasterMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.linearDisasterMapper.deleteByPrimaryKey(id);
	}

}
