package com.yoxnet.log.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yoxnet.common.code.ErrCodeE;
import javax.yoxnet.common.exception.BusinessException;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.common.utils.Stringer;
import com.yoxnet.log.service.LogService;
import com.yoxnet.log.bean.Log;
import com.yoxnet.log.bean.LogExample;
import com.yoxnet.log.bean.LogExample.Criteria;
import com.yoxnet.log.dao.LogMapper;


@Service("LogService")
public class LogServiceImpl implements LogService {

	private final static Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

	@Resource
	private LogMapper logMapper;


	@Override
	public void save(Log log) {

		if (null == log) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.logMapper.insertSelective(log);
	}

	@Override
	public void update(Log log) {
		if (null == log) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.logMapper.updateByPrimaryKeySelective(log);
	}

	@Override
	public Log getById(String id) {
		return logMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Log> list(Log log) {
		return this.list(log, null);
	}

	@Override
	public List<Log> list(Log log, String orderByStr) {
		LogExample example = new LogExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<Log> logList = this.logMapper.selectByExample(example);
		return logList;
	}

	@Override
	public PageResult<Log> findPageByParam(Log log, PageParam pageParam) {
		return this.findPageByParam(log, pageParam, null);
	}

	@Override
	public PageResult<Log> findPageByParam(Log log, PageParam pageParam, String orderByStr) {
		PageResult<Log> pageResult = new PageResult<Log>();

		LogExample example = new LogExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<Log> list = logMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.logMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Log> selectAllLogAndOwner(String username, Integer pageNum,Integer size) {
		// TODO Auto-generated method stub
		
		if(Stringer.isNullOrEmpty(username)){
			return null;
		}
		
		if(pageNum==null){
			pageNum=0;
		}
		
		if(size == null){
			size = 10;
		}
		
		return logMapper.selectAllLogAndOwner(username, pageNum*size, size);
	}

	
	
}
