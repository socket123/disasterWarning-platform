package com.yoxnet.kilometerPileInfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.github.pagehelper.PageHelper;
import com.yoxnet.common.code.ErrCodeE;
import javax.yoxnet.common.exception.BusinessException;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.kilometerPileInfo.service.KilometerPileInfoService;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfoExample;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfoExample.Criteria;
import com.yoxnet.kilometerPileInfo.dao.KilometerPileInfoMapper;


@Service("kilometerPileInfoService")
public class KilometerPileInfoServiceImpl implements KilometerPileInfoService {

	private final static Logger logger = LoggerFactory.getLogger(KilometerPileInfoServiceImpl.class);

	@Resource
	private KilometerPileInfoMapper kilometerPileInfoMapper;
	
	@Override
	public KilometerPileInfo select(String pileId) {
		if (StringUtils.isEmpty(pileId)) {
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		
		KilometerPileInfoExample Example = new KilometerPileInfoExample();
		Criteria ct = Example.or();
		ct.andKilometerPileIdEqualTo(pileId);
		
		List<KilometerPileInfo> kilometerPileInfo =  this.kilometerPileInfoMapper.selectByExample(Example);
		if(CollectionUtils.isEmpty(kilometerPileInfo)){
			return null;
		}
		return kilometerPileInfo.get(0);
	}

	@Override
	public List<KilometerPileInfo> selectByStartEnd(Integer start,Integer end) {
		
		if(start == null || start == 0){
			throw new BusinessException(ErrCodeE.NO_RECORD.getCode(), ErrCodeE.NO_RECORD.getName());
		}
		
		if(end == null || end == 0){
			throw new BusinessException(ErrCodeE.NO_RECORD.getCode(), ErrCodeE.NO_RECORD.getName());
		}
		
		KilometerPileInfoExample Example = new KilometerPileInfoExample();
		Criteria ct = Example.or();
		ct.andIdBetween(start, end);
		
		List<KilometerPileInfo> kilometerPileInfo =  this.kilometerPileInfoMapper.selectByExample(Example);
		return kilometerPileInfo;
	}

	@Override
	public void save(KilometerPileInfo kilometerPileInfo) {
		if (null == kilometerPileInfo) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.kilometerPileInfoMapper.insertSelective(kilometerPileInfo);
	}

	@Override
	public void update(KilometerPileInfo kilometerPileInfo) {
		if (null == kilometerPileInfo) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.kilometerPileInfoMapper.updateByPrimaryKeySelective(kilometerPileInfo);
	}

	@Override
	public KilometerPileInfo getById(Integer id) {
		return kilometerPileInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<KilometerPileInfo> list(KilometerPileInfo kilometerPileInfo) {
		return this.list(kilometerPileInfo, null);
	}

	@Override
	public List<KilometerPileInfo> list(KilometerPileInfo kilometerPileInfo, String orderByStr) {
		KilometerPileInfoExample example = new KilometerPileInfoExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<KilometerPileInfo> kilometerPileInfoList = this.kilometerPileInfoMapper.selectByExample(example);
		return kilometerPileInfoList;
	}

	@Override
	public PageResult<KilometerPileInfo> findPageByParam(KilometerPileInfo kilometerPileInfo, PageParam pageParam) {
		return this.findPageByParam(kilometerPileInfo, pageParam, null);
	}

	@Override
	public PageResult<KilometerPileInfo> findPageByParam(KilometerPileInfo kilometerPileInfo, PageParam pageParam, String orderByStr) {
		PageResult<KilometerPileInfo> pageResult = new PageResult<KilometerPileInfo>();

		KilometerPileInfoExample example = new KilometerPileInfoExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<KilometerPileInfo> list = kilometerPileInfoMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(Integer id) {
		this.kilometerPileInfoMapper.deleteByPrimaryKey(id);
	}

}
