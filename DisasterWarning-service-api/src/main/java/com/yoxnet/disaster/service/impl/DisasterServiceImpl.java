package com.yoxnet.disaster.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.yoxnet.common.exception.BusinessException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.constant.Globals;
import com.yoxnet.common.utils.DateUtiler;
import com.yoxnet.disaster.service.DisasterService;
import com.yoxnet.disaster.vo.DisasterVO;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;
import com.yoxnet.kilometerPileInfo.service.KilometerPileInfoService;
import com.yoxnet.linearDisaster.bean.LinearDisaster;
import com.yoxnet.linearDisaster.service.LinearDisasterService;
import com.yoxnet.pointDisaster.bean.PointDisaster;
import com.yoxnet.pointDisaster.service.PointDisasterService;


@Service("DisasterService")
public class DisasterServiceImpl implements DisasterService {

	private final static Logger logger = LoggerFactory.getLogger(DisasterServiceImpl.class);

	@Resource
	private LinearDisasterService linearDisasterService;

	@Resource
	private PointDisasterService pointDisasterService;

	@Resource
	private KilometerPileInfoService pileInfoService;

	@Override
	public ServiceResult<Object> getDisaster(DisasterVO disasterVO) {

		String taskName = disasterVO.getTaskName();
		String time = disasterVO.getStartTime();

		if(StringUtils.isEmpty(taskName)){
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}

		if(StringUtils.isEmpty(time)){
			time = DateUtiler.getNow();
		}


		//线状灾害数据查询
		List<LinearDisaster> LinearDisasterList =  (List<LinearDisaster>) linearDisasterService.getByLinearDisaster(taskName,time).getResult();

		List<DisasterVO> voList =  new ArrayList<DisasterVO>();

		if(CollectionUtils.isNotEmpty(LinearDisasterList)){

			for(LinearDisaster disaster:LinearDisasterList){

				List<KilometerPileInfo> pileList = new ArrayList<KilometerPileInfo>();

				KilometerPileInfo pileInfoStart = null;
				KilometerPileInfo pileInfoEnd = null;

				//开始公里桩数据
				String start = disaster.getStartPileId();
				//结束桩点
				String end = disaster.getEndPileId();

				if(StringUtils.isNotEmpty(start)){
					//查询线性灾害，开始公里桩数据
					pileInfoStart = pileInfoService.select(start);
				}

				//结束公里桩数据添加
				if(StringUtils.isNotEmpty(end)){
					//查询线性灾害，结束公里桩数据
					pileInfoEnd = pileInfoService.select(end);
				}

				//中间公里桩数据
				List<KilometerPileInfo> pileInfoList = pileInfoService.selectByStartEnd(pileInfoStart.getId(), pileInfoEnd.getId());

				//按桩点开始结束顺序添加集合

				for(KilometerPileInfo pileInfo:pileInfoList){
					pileList.add(pileInfo);
				}

				DisasterVO dis = disaster.toCommandVO();
				dis.setPileList(pileList);
				dis.setDisasterState(Globals.LINEAR);
				voList.add(dis);
			}
		}

		//点状灾害数据查询
		List<PointDisaster> disasterList = (List<PointDisaster>) pointDisasterService.getByPointDisaster(taskName, time).getResult();

		if(CollectionUtils.isNotEmpty(disasterList)){

			for(PointDisaster disaster:disasterList){

				List<KilometerPileInfo> pileList = new ArrayList<KilometerPileInfo>();

				String pileInfoId = disaster.getKilometerPileId();

				if(StringUtils.isNotEmpty(pileInfoId)){
					//查询点型灾害，公里桩数据
					KilometerPileInfo pileInfo = pileInfoService.select(pileInfoId);
					pileList.add(pileInfo);
				}

				DisasterVO dis = disaster.toCommandVO();
				dis.setPileList(pileList);
				dis.setDisasterState(Globals.POINT);
				voList.add(dis);
			}
		}

		return ServiceTool.buildSuccessResult(voList);
	}
}
