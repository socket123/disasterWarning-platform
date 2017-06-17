package com.yoxnet.waterSystemHydrology.service.impl;

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
import com.yoxnet.waterSystemHydrology.service.WaterSystemHydrologyService;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrology;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrologyExample;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrologyExample.Criteria;
import com.yoxnet.waterSystemHydrology.dao.WaterSystemHydrologyMapper;


@Service("waterSystemHydrologyService")
public class WaterSystemHydrologyServiceImpl implements WaterSystemHydrologyService {

	private final static Logger logger = LoggerFactory.getLogger(WaterSystemHydrologyServiceImpl.class);

	@Resource
	private WaterSystemHydrologyMapper waterSystemHydrologyMapper;

	@Override
	public ServiceResult<Object> getWaterSystemHydrology(String time) {
		try {
			if(StringUtils.isEmpty(time)){
				throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
			}
			String[] dayTimes = time.split(" ");
			String dayTimeStart = dayTimes[0]+" 00:00:00";
			String dayTimeEnd = dayTimes[0]+" 23:59:59";
			WaterSystemHydrologyExample example = new WaterSystemHydrologyExample();
			Criteria criteria = example.or();
			
			if(StringUtils.isNotEmpty(dayTimeStart) && StringUtils.isNotEmpty(dayTimeEnd)){
				criteria.andTimeGreaterThanOrEqualTo(dayTimeStart);
				criteria.andTimeLessThanOrEqualTo(dayTimeEnd);
			}
			
			List<WaterSystemHydrology> list = waterSystemHydrologyMapper.selectByExample(example);
			
			return ServiceTool.buildSuccessResult(list);
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}	

	@Override
	public void save(WaterSystemHydrology waterSystemHydrology) {
		if (null == waterSystemHydrology) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.waterSystemHydrologyMapper.insertSelective(waterSystemHydrology);
	}

	@Override
	public void update(WaterSystemHydrology waterSystemHydrology) {
		if (null == waterSystemHydrology) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.waterSystemHydrologyMapper.updateByPrimaryKeySelective(waterSystemHydrology);
	}

	@Override
	public WaterSystemHydrology getById(String id) {
		return waterSystemHydrologyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WaterSystemHydrology> list(WaterSystemHydrology waterSystemHydrology) {
		return this.list(waterSystemHydrology, null);
	}

	@Override
	public List<WaterSystemHydrology> list(WaterSystemHydrology waterSystemHydrology, String orderByStr) {
		WaterSystemHydrologyExample example = new WaterSystemHydrologyExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<WaterSystemHydrology> waterSystemHydrologyList = this.waterSystemHydrologyMapper.selectByExample(example);
		return waterSystemHydrologyList;
	}

	@Override
	public PageResult<WaterSystemHydrology> findPageByParam(WaterSystemHydrology waterSystemHydrology, PageParam pageParam) {
		return this.findPageByParam(waterSystemHydrology, pageParam, null);
	}

	@Override
	public PageResult<WaterSystemHydrology> findPageByParam(WaterSystemHydrology waterSystemHydrology, PageParam pageParam, String orderByStr) {
		PageResult<WaterSystemHydrology> pageResult = new PageResult<WaterSystemHydrology>();

		WaterSystemHydrologyExample example = new WaterSystemHydrologyExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<WaterSystemHydrology> list = waterSystemHydrologyMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.waterSystemHydrologyMapper.deleteByPrimaryKey(id);
	}

}
