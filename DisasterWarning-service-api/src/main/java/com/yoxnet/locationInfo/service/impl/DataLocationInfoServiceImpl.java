package com.yoxnet.locationInfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yoxnet.common.code.ErrCodeE;
import javax.yoxnet.common.exception.BusinessException;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.locationInfo.service.DataLocationInfoService;
import com.yoxnet.locationInfo.bean.DataLocationInfo;
import com.yoxnet.locationInfo.bean.DataLocationInfoExample;
import com.yoxnet.locationInfo.bean.DataLocationInfoExample.Criteria;
import com.yoxnet.locationInfo.dao.DataLocationInfoMapper;


@Service("dataLocationInfoService")
public class DataLocationInfoServiceImpl implements DataLocationInfoService {

	private final static Logger logger = LoggerFactory.getLogger(DataLocationInfoServiceImpl.class);

	@Resource
	private DataLocationInfoMapper dataLocationInfoMapper;


	@Override
	public void save(DataLocationInfo dataLocationInfo) {
		if (null == dataLocationInfo) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.dataLocationInfoMapper.insertSelective(dataLocationInfo);
	}

	@Override
	public void update(DataLocationInfo dataLocationInfo) {
		if (null == dataLocationInfo) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.dataLocationInfoMapper.updateByPrimaryKeySelective(dataLocationInfo);
	}

	@Override
	public DataLocationInfo getById(String id) {
		return dataLocationInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DataLocationInfo> list(DataLocationInfo dataLocationInfo) {
		return this.list(dataLocationInfo, null);
	}

	@Override
	public List<DataLocationInfo> list(DataLocationInfo dataLocationInfo, String orderByStr) {
		DataLocationInfoExample example = new DataLocationInfoExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<DataLocationInfo> dataLocationInfoList = this.dataLocationInfoMapper.selectByExample(example);
		return dataLocationInfoList;
	}

	@Override
	public PageResult<DataLocationInfo> findPageByParam(DataLocationInfo dataLocationInfo, PageParam pageParam) {
		return this.findPageByParam(dataLocationInfo, pageParam, null);
	}

	@Override
	public PageResult<DataLocationInfo> findPageByParam(DataLocationInfo dataLocationInfo, PageParam pageParam, String orderByStr) {
		PageResult<DataLocationInfo> pageResult = new PageResult<DataLocationInfo>();

		DataLocationInfoExample example = new DataLocationInfoExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<DataLocationInfo> list = dataLocationInfoMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.dataLocationInfoMapper.deleteByPrimaryKey(id);
	}

}
