package com.yoxnet.pointDisaster.service.impl;

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
import com.yoxnet.linearDisaster.bean.LinearDisasterExample;
import com.yoxnet.pointDisaster.service.PointDisasterService;
import com.yoxnet.pointDisaster.bean.PointDisaster;
import com.yoxnet.pointDisaster.bean.PointDisasterExample;
import com.yoxnet.pointDisaster.bean.PointDisasterExample.Criteria;
import com.yoxnet.pointDisaster.dao.PointDisasterMapper;


@Service("pointDisasterService")
public class PointDisasterServiceImpl implements PointDisasterService {

	private final static Logger logger = LoggerFactory.getLogger(PointDisasterServiceImpl.class);

	@Resource
	private PointDisasterMapper pointDisasterMapper;

	@Override
	public ServiceResult<Object> getByPointDisaster(String taskName,String StartTime) {
		try {
			if(null == taskName){
				return ServiceTool.buildApplicationFailResult("任务名称不可为空");
			}
			PointDisasterExample example = new PointDisasterExample();
			Criteria criteria = example.or();
			criteria.andTaskNameEqualTo(taskName);
			if(StringUtils.isNotEmpty(StartTime)){
				criteria.andStartTimeLessThan(StartTime);
				criteria.andEndTimeGreaterThan(StartTime);
			}
			return ServiceTool.buildSuccessResult(pointDisasterMapper.selectByExample(example));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}

	@Override
	public void save(PointDisaster pointDisaster) {
		if (null == pointDisaster) {
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.pointDisasterMapper.insertSelective(pointDisaster);
	}

	@Override
	public void update(PointDisaster pointDisaster) {
		if (null == pointDisaster) {
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.pointDisasterMapper.updateByPrimaryKeySelective(pointDisaster);
	}

	@Override
	public PointDisaster getById(String id) {
		return pointDisasterMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PointDisaster> list(PointDisaster pointDisaster) {
		return this.list(pointDisaster, null);
	}

	@Override
	public List<PointDisaster> list(PointDisaster pointDisaster, String orderByStr) {
		PointDisasterExample example = new PointDisasterExample();
		if (StringUtils.isNotBlank(orderByStr)) {
			example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<PointDisaster> pointDisasterList = this.pointDisasterMapper.selectByExample(example);
		return pointDisasterList;
	}

	@Override
	public PageResult<PointDisaster> findPageByParam(PointDisaster pointDisaster, PageParam pageParam) {
		return this.findPageByParam(pointDisaster, pageParam, null);
	}

	@Override
	public PageResult<PointDisaster> findPageByParam(PointDisaster pointDisaster, PageParam pageParam, String orderByStr) {
		PageResult<PointDisaster> pageResult = new PageResult<PointDisaster>();

		PointDisasterExample example = new PointDisasterExample();
		if (StringUtils.isNotBlank(orderByStr)) {
			example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<PointDisaster> list = pointDisasterMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.pointDisasterMapper.deleteByPrimaryKey(id);
	}

}
