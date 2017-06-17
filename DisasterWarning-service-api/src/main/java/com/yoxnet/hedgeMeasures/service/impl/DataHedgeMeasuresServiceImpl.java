package com.yoxnet.hedgeMeasures.service.impl;

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
import com.yoxnet.hedgeMeasures.service.DataHedgeMeasuresService;
import com.yoxnet.hedgeMeasures.bean.DataHedgeMeasures;
import com.yoxnet.hedgeMeasures.bean.DataHedgeMeasuresExample;
import com.yoxnet.hedgeMeasures.bean.DataHedgeMeasuresExample.Criteria;
import com.yoxnet.hedgeMeasures.dao.DataHedgeMeasuresMapper;


@Service("dataHedgeMeasuresService")
public class DataHedgeMeasuresServiceImpl implements DataHedgeMeasuresService {

	private final static Logger logger = LoggerFactory.getLogger(DataHedgeMeasuresServiceImpl.class);

	@Resource
	private DataHedgeMeasuresMapper dataHedgeMeasuresMapper;


	@Override
	public void save(DataHedgeMeasures dataHedgeMeasures) {
		if (null == dataHedgeMeasures) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.dataHedgeMeasuresMapper.insertSelective(dataHedgeMeasures);
	}

	@Override
	public void update(DataHedgeMeasures dataHedgeMeasures) {
		if (null == dataHedgeMeasures) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.dataHedgeMeasuresMapper.updateByPrimaryKeySelective(dataHedgeMeasures);
	}

	@Override
	public DataHedgeMeasures getById(String id) {
		return dataHedgeMeasuresMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DataHedgeMeasures> list(DataHedgeMeasures dataHedgeMeasures) {
		return this.list(dataHedgeMeasures, null);
	}

	@Override
	public List<DataHedgeMeasures> list(DataHedgeMeasures dataHedgeMeasures, String orderByStr) {
		DataHedgeMeasuresExample example = new DataHedgeMeasuresExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<DataHedgeMeasures> dataHedgeMeasuresList = this.dataHedgeMeasuresMapper.selectByExample(example);
		return dataHedgeMeasuresList;
	}

	@Override
	public PageResult<DataHedgeMeasures> findPageByParam(DataHedgeMeasures dataHedgeMeasures, PageParam pageParam) {
		return this.findPageByParam(dataHedgeMeasures, pageParam, null);
	}

	@Override
	public PageResult<DataHedgeMeasures> findPageByParam(DataHedgeMeasures dataHedgeMeasures, PageParam pageParam, String orderByStr) {
		PageResult<DataHedgeMeasures> pageResult = new PageResult<DataHedgeMeasures>();

		DataHedgeMeasuresExample example = new DataHedgeMeasuresExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<DataHedgeMeasures> list = dataHedgeMeasuresMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.dataHedgeMeasuresMapper.deleteByPrimaryKey(id);
	}

}
