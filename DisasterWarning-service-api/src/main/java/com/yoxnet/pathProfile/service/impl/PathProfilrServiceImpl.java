package com.yoxnet.pathProfile.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.pathProfile.bean.PathProfile;
import com.yoxnet.pathProfile.bean.PathProfileExample;
import com.yoxnet.pathProfile.dao.PathProfileMapper;
import com.yoxnet.pathProfile.service.PathProfilrService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import  com.yoxnet.pathProfile.bean.PathProfileExample.Criteria;
import javax.annotation.Resource;
import javax.yoxnet.common.exception.BusinessException;
import java.util.List;


@Service("PathProfilrService")
public class PathProfilrServiceImpl implements PathProfilrService {

	private final static Logger logger = LoggerFactory.getLogger(PathProfilrServiceImpl.class);

	@Resource
	private PathProfileMapper pathProfileMapper;
	
	
	@Override
	public ServiceResult<Object> getByLinearDisaster(String taskName,String StartTime) {
		try {
			if(null == taskName){
				return ServiceTool.buildApplicationFailResult("任务名称不可为空");
			}
			PathProfileExample example = new PathProfileExample();
			Criteria criteria = example.or();
			criteria.andTaskNameEqualTo(taskName);
			if(StringUtils.isNotEmpty(StartTime)){
				criteria.andStartTimeLessThan(StartTime);
				criteria.andEndTimeGreaterThan(StartTime);

			}
			return ServiceTool.buildSuccessResult(pathProfileMapper.selectByExample(example));
		} catch (Exception e) {
			return ServiceTool.buildApplicationFailResult("查询失败");
		}
	}

	@Override
	public void save(PathProfile pathProfile) {
		if (null == pathProfile) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.pathProfileMapper.insertSelective(pathProfile);
	}

	@Override
	public void update(PathProfile pathProfile) {
		if (null == pathProfile) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.pathProfileMapper.updateByPrimaryKeySelective(pathProfile);
	}

	@Override
	public PathProfile getById(String id) {
		return pathProfileMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PathProfile> list(PathProfile pathProfile) {
		return this.list(pathProfile, null);
	}

	@Override
	public List<PathProfile> list(PathProfile pathProfile, String orderByStr) {
		PathProfileExample example = new PathProfileExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<PathProfile> pathProfileList = this.pathProfileMapper.selectByExample(example);
		return pathProfileList;
	}

	@Override
	public PageResult<PathProfile> findPageByParam(PathProfile pathProfile, PageParam pageParam) {
		return this.findPageByParam(pathProfile, pageParam, null);
	}

	@Override
	public PageResult<PathProfile> findPageByParam(PathProfile pathProfile, PageParam pageParam, String orderByStr) {
		PageResult<PathProfile> pageResult = new PageResult<PathProfile>();

		PathProfileExample example = new PathProfileExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<PathProfile> list = pathProfileMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.pathProfileMapper.deleteByPrimaryKey(id);
	}

}
