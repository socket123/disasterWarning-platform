package com.yoxnet.waterSystemLocation.service.impl;

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
import com.yoxnet.waterSystemLocation.service.WaterSystemLocationService;
import com.yoxnet.waterSystemLocation.bean.WaterSystemLocation;
import com.yoxnet.waterSystemLocation.bean.WaterSystemLocationExample;
import com.yoxnet.waterSystemLocation.bean.WaterSystemLocationExample.Criteria;
import com.yoxnet.waterSystemLocation.dao.WaterSystemLocationMapper;


@Service("waterSystemLocationService")
public class WaterSystemLocationServiceImpl implements WaterSystemLocationService {

	private final static Logger logger = LoggerFactory.getLogger(WaterSystemLocationServiceImpl.class);

	@Resource
	private WaterSystemLocationMapper waterSystemLocationMapper;

	@Override
	public ServiceResult<Object> getWaterSystemLocation(String waterSysId) {
		try {
			if(StringUtils.isEmpty(waterSysId)){
				return ServiceTool.buildApplicationFailResult("水系编号不可为空");
			}
			WaterSystemLocationExample example = new WaterSystemLocationExample();
			Criteria criteria = example.or();
			criteria.andWaterSysIdEqualTo(waterSysId);
			return ServiceTool.buildSuccessResult(waterSystemLocationMapper.selectByExample(example));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}	
	
	@Override
	public void save(WaterSystemLocation waterSystemLocation) {
		if (null == waterSystemLocation) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.waterSystemLocationMapper.insertSelective(waterSystemLocation);
	}

	@Override
	public void update(WaterSystemLocation waterSystemLocation) {
		if (null == waterSystemLocation) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.waterSystemLocationMapper.updateByPrimaryKeySelective(waterSystemLocation);
	}

	@Override
	public WaterSystemLocation getById(String id) {
		return waterSystemLocationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WaterSystemLocation> list(WaterSystemLocation waterSystemLocation) {
		return this.list(waterSystemLocation, null);
	}

	@Override
	public List<WaterSystemLocation> list(WaterSystemLocation waterSystemLocation, String orderByStr) {
		WaterSystemLocationExample example = new WaterSystemLocationExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<WaterSystemLocation> waterSystemLocationList = this.waterSystemLocationMapper.selectByExample(example);
		return waterSystemLocationList;
	}

	@Override
	public PageResult<WaterSystemLocation> findPageByParam(WaterSystemLocation waterSystemLocation, PageParam pageParam) {
		return this.findPageByParam(waterSystemLocation, pageParam, null);
	}

	@Override
	public PageResult<WaterSystemLocation> findPageByParam(WaterSystemLocation waterSystemLocation, PageParam pageParam, String orderByStr) {
		PageResult<WaterSystemLocation> pageResult = new PageResult<WaterSystemLocation>();

		WaterSystemLocationExample example = new WaterSystemLocationExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<WaterSystemLocation> list = waterSystemLocationMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.waterSystemLocationMapper.deleteByPrimaryKey(id);
	}

}
