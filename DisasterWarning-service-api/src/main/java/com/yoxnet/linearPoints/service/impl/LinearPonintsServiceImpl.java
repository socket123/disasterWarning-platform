package com.yoxnet.linearPoints.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.yoxnet.linearPoints.bean.LinearPointsExample;
import com.yoxnet.linearPoints.dao.LinearPointsMapper;

import com.yoxnet.linearPoints.service.LinearPonintsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import  com.yoxnet.linearPoints.bean.LinearPointsExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import javax.yoxnet.common.exception.BusinessException;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;

import com.yoxnet.linearPoints.bean.LinearPoints;



@Service("LinearPonintsService")
public class LinearPonintsServiceImpl implements LinearPonintsService {

	private final static Logger logger = LoggerFactory.getLogger(LinearPonintsServiceImpl.class);

	@Resource
	private LinearPointsMapper linearPointsMapper;
	
	
	@Override
	public ServiceResult<Object> getByLinearDisaster(String taskName,String StartTime) {
		try {
			if(null == taskName){
				return ServiceTool.buildApplicationFailResult("任务名称不可为空");
			}
			LinearPointsExample example = new LinearPointsExample();
			Criteria criteria = example.or();
			criteria.andTaskNameEqualTo(taskName);
			if(StringUtils.isNotEmpty(StartTime)){
				criteria.andStartTimeLessThan(StartTime);
				criteria.andEndTimeGreaterThan(StartTime);
			}
			System.out.println();
			return ServiceTool.buildSuccessResult(linearPointsMapper.selectByExample(example));
		} catch (Exception e) {
			System.out.println("查询失败");
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}

	@Override
	public void save(LinearPoints linearDisaster) {
		if (null == linearDisaster) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.linearPointsMapper.insertSelective(linearDisaster);
	}

	@Override
	public void update(LinearPoints linearDisaster) {
		if (null == linearDisaster) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.linearPointsMapper.updateByPrimaryKeySelective(linearDisaster);
	}

	@Override
	public LinearPoints getById(String id) {
		return linearPointsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LinearPoints> list(LinearPoints linearDisaster) {
		return this.list(linearDisaster, null);
	}

	@Override
	public List<LinearPoints> list(LinearPoints linearDisaster, String orderByStr) {
		LinearPointsExample example = new LinearPointsExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<LinearPoints> linearDisasterList = this.linearPointsMapper.selectByExample(example);
		return linearDisasterList;
	}

	@Override
	public PageResult<LinearPoints> findPageByParam(LinearPoints linearDisaster, PageParam pageParam) {
		return this.findPageByParam(linearDisaster, pageParam, null);
	}

	@Override
	public PageResult<LinearPoints> findPageByParam(LinearPoints linearDisaster, PageParam pageParam, String orderByStr) {
		PageResult<LinearPoints> pageResult = new PageResult<LinearPoints>();

		LinearPointsExample example = new LinearPointsExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		System.out.println();
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<LinearPoints> list = linearPointsMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.linearPointsMapper.deleteByPrimaryKey(id);
	}

}
