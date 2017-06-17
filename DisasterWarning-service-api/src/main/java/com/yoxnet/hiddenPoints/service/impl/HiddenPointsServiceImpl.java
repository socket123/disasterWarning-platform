package com.yoxnet.hiddenPoints.service.impl;


import javax.annotation.Resource;


import com.yoxnet.hiddenPoints.bean.HiddenPoints;
import com.yoxnet.hiddenPoints.bean.HiddenPointsExample;
import com.yoxnet.hiddenPoints.bean.HiddenPointsExample.Criteria;
import com.yoxnet.hiddenPoints.dao.HiddenPointsMapper;
import com.yoxnet.hiddenPoints.service.HiddenPointsService;
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

import java.util.List;


@Service("HiddenPointsService")
public class HiddenPointsServiceImpl implements HiddenPointsService {

	private final static Logger logger = LoggerFactory.getLogger(HiddenPointsServiceImpl.class);

	@Resource
	private HiddenPointsMapper hiddenPointsMapper;

	@Override
	public ServiceResult<Object> getByPointDisaster(String taskName,String StartTime) {
		try {
			if(null == taskName){
				return ServiceTool.buildApplicationFailResult("任务名称不可为空");
			}
			HiddenPointsExample example = new HiddenPointsExample();
			HiddenPointsExample.Criteria criteria = example.or();
			criteria.andTaskNameEqualTo(taskName);
			if(StringUtils.isNotEmpty(StartTime)){
				criteria.andStartTimeLessThan(StartTime);
				criteria.andEndTimeGreaterThan(StartTime);
			}
			return ServiceTool.buildSuccessResult(hiddenPointsMapper.selectByExample(example));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}	
	
	@Override
	public void save(HiddenPoints hiddenPoints) {
		if (null == hiddenPoints) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.hiddenPointsMapper.insertSelective(hiddenPoints);
	}

	@Override
	public void update(HiddenPoints hiddenPoints) {
		if (null == hiddenPoints) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.hiddenPointsMapper.updateByPrimaryKeySelective(hiddenPoints);
	}

	@Override
	public HiddenPoints getById(String id) {
		return hiddenPointsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HiddenPoints> list(HiddenPoints hiddenPoints) {
		return this.list(hiddenPoints, null);
	}

	@Override
	public List<HiddenPoints> list(HiddenPoints hiddenPoints, String orderByStr) {
		HiddenPointsExample example = new HiddenPointsExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<HiddenPoints> hiddenPointsList = this.hiddenPointsMapper.selectByExample(example);
		return hiddenPointsList;
	}

	@Override
	public PageResult<HiddenPoints> findPageByParam(HiddenPoints hiddenPoints, PageParam pageParam) {
		return this.findPageByParam(hiddenPoints, pageParam, null);
	}

	@Override
	public PageResult<HiddenPoints> findPageByParam(HiddenPoints hiddenPoints, PageParam pageParam, String orderByStr) {
		PageResult<HiddenPoints> pageResult = new PageResult<HiddenPoints>();

		HiddenPointsExample example = new HiddenPointsExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<HiddenPoints> list = hiddenPointsMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.hiddenPointsMapper.deleteByPrimaryKey(id);
	}

}
