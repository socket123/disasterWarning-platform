package com.yoxnet.waterSystemInfo.service.impl;

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
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrologyExample;
import com.yoxnet.waterSystemInfo.service.WaterSystemInfoService;
import com.yoxnet.waterSystemInfo.bean.WaterSystemInfo;
import com.yoxnet.waterSystemInfo.bean.WaterSystemInfoExample;
import com.yoxnet.waterSystemInfo.bean.WaterSystemInfoExample.Criteria;
import com.yoxnet.waterSystemInfo.dao.WaterSystemInfoMapper;


@Service("waterSystemInfoService")
public class WaterSystemInfoServiceImpl implements WaterSystemInfoService {

	private final static Logger logger = LoggerFactory.getLogger(WaterSystemInfoServiceImpl.class);

	@Resource
	private WaterSystemInfoMapper waterSystemInfoMapper;
	
	@Override
	public ServiceResult<Object> getWaterSystemInfo(String waterSysId) {
		try {
			if(StringUtils.isEmpty(waterSysId)){
				return ServiceTool.buildApplicationFailResult("水系编号不可为空");
			}
			WaterSystemInfoExample example = new WaterSystemInfoExample();
			Criteria criteria = example.or();
			criteria.andWaterSysIdEqualTo(waterSysId);
			
			List<WaterSystemInfo> infoList = waterSystemInfoMapper.selectByExample(example);
			if(CollectionUtils.isEmpty(infoList)){
				return ServiceTool.buildSuccessResult(null);
			}
			
			return ServiceTool.buildSuccessResult(infoList.get(0));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}	

	@Override
	public void save(WaterSystemInfo waterSystemInfo) {
		if (null == waterSystemInfo) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.waterSystemInfoMapper.insertSelective(waterSystemInfo);
	}

	@Override
	public void update(WaterSystemInfo waterSystemInfo) {
		if (null == waterSystemInfo) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.waterSystemInfoMapper.updateByPrimaryKeySelective(waterSystemInfo);
	}

	@Override
	public WaterSystemInfo getById(Integer id) {
		return waterSystemInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WaterSystemInfo> list(WaterSystemInfo waterSystemInfo) {
		return this.list(waterSystemInfo, null);
	}

	@Override
	public List<WaterSystemInfo> list(WaterSystemInfo waterSystemInfo, String orderByStr) {
		WaterSystemInfoExample example = new WaterSystemInfoExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<WaterSystemInfo> waterSystemInfoList = this.waterSystemInfoMapper.selectByExample(example);
		return waterSystemInfoList;
	}

	@Override
	public PageResult<WaterSystemInfo> findPageByParam(WaterSystemInfo waterSystemInfo, PageParam pageParam) {
		return this.findPageByParam(waterSystemInfo, pageParam, null);
	}

	@Override
	public PageResult<WaterSystemInfo> findPageByParam(WaterSystemInfo waterSystemInfo, PageParam pageParam, String orderByStr) {
		PageResult<WaterSystemInfo> pageResult = new PageResult<WaterSystemInfo>();

		WaterSystemInfoExample example = new WaterSystemInfoExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<WaterSystemInfo> list = waterSystemInfoMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(Integer id) {
		this.waterSystemInfoMapper.deleteByPrimaryKey(id);
	}

}
