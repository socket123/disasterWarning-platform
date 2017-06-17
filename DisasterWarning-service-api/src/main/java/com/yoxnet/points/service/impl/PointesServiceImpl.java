package com.yoxnet.points.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.yoxnet.common.exception.BusinessException;

import com.yoxnet.hiddenPoints.bean.HiddenPoints;
import com.yoxnet.hiddenPoints.service.HiddenPointsService;
import com.yoxnet.linearPoints.bean.LinearPoints;
import com.yoxnet.linearPoints.service.LinearPonintsService;
import com.yoxnet.points.service.PointesService;
import com.yoxnet.points.vo.PointesVO;
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


import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;
import com.yoxnet.kilometerPileInfo.service.KilometerPileInfoService;



@Service("PointesService")
public class PointesServiceImpl implements PointesService {

	private final static Logger logger = LoggerFactory.getLogger(PointesServiceImpl.class);

	@Resource
	private LinearPonintsService linearPonintsService;

	@Resource
	private HiddenPointsService hiddenPointsService;

	@Resource
	private KilometerPileInfoService pileInfoService;

	@Override
	public ServiceResult<Object> getDisaster_liness(PointesVO PointesVO) {
		String taskName = PointesVO.getTaskName();
		String time = PointesVO.getStartTime();

		if(StringUtils.isEmpty(taskName)){
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}

		if(StringUtils.isEmpty(time)){
			time = DateUtiler.getNow();
		}


		//线状灾害数据查询
		List<LinearPoints> LinearDisasterList =  (List<LinearPoints>) linearPonintsService.getByLinearDisaster(taskName,time).getResult();

		List<PointesVO> voList =  new ArrayList<PointesVO>();

		if(CollectionUtils.isNotEmpty(LinearDisasterList)){

			for(LinearPoints disaster:LinearDisasterList){

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

				PointesVO dis = disaster.toCommandVO();
				dis.setPileList(pileList);
				dis.setDisasterState(Globals.LINEAR);
				voList.add(dis);
			}
		}

		return ServiceTool.buildSuccessResult(voList);
	}

	@Override
	public ServiceResult<Object> getDisaster(PointesVO PointesVO) {

		String taskName = PointesVO.getTaskName();
		String time = PointesVO.getStartTime();

		if(StringUtils.isEmpty(taskName)){
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}

		if(StringUtils.isEmpty(time)){
			time = DateUtiler.getNow();
		}
		List<PointesVO> voList =  new ArrayList<PointesVO>();

//		//线状灾害数据查询
//		List<LinearPoints> LinearDisasterList =  (List<LinearPoints>) linearPonintsService.getByLinearDisaster(taskName,time).getResult();
//
//		List<PointesVO> voList =  new ArrayList<PointesVO>();
//
//		if(CollectionUtils.isNotEmpty(LinearDisasterList)){
//
//			for(LinearPoints disaster:LinearDisasterList){
//
//				List<KilometerPileInfo> pileList = new ArrayList<KilometerPileInfo>();
//
//				KilometerPileInfo pileInfoStart = null;
//				KilometerPileInfo pileInfoEnd = null;
//
//				//开始公里桩数据
//				String start = disaster.getStartPileId();
//				//结束桩点
//				String end = disaster.getEndPileId();
//
//				if(StringUtils.isNotEmpty(start)){
//					//查询线性灾害，开始公里桩数据
//					pileInfoStart = pileInfoService.select(start);
//				}
//
//				//结束公里桩数据添加
//				if(StringUtils.isNotEmpty(end)){
//					//查询线性灾害，结束公里桩数据
//					pileInfoEnd = pileInfoService.select(end);
//				}
//
//				//中间公里桩数据
//				List<KilometerPileInfo> pileInfoList = pileInfoService.selectByStartEnd(pileInfoStart.getId(), pileInfoEnd.getId());
//
//				//按桩点开始结束顺序添加集合
//
//				for(KilometerPileInfo pileInfo:pileInfoList){
//					pileList.add(pileInfo);
//				}
//
//				PointesVO dis = disaster.toCommandVO();
//				dis.setPileList(pileList);
//				dis.setDisasterState(Globals.LINEAR);
//				voList.add(dis);
//			}
//		}

		//点状灾害数据查询
		List<HiddenPoints> disasterList = (List<HiddenPoints>) hiddenPointsService.getByPointDisaster(taskName, time).getResult();

		if(CollectionUtils.isNotEmpty(disasterList)){

			for(HiddenPoints disaster:disasterList){

				List<KilometerPileInfo> pileList = new ArrayList<KilometerPileInfo>();

				String pileInfoId = disaster.getKilometerPileId();

				if(StringUtils.isNotEmpty(pileInfoId)){
					//查询点型灾害，公里桩数据
					KilometerPileInfo pileInfo = pileInfoService.select(pileInfoId);
					pileList.add(pileInfo);
				}

				PointesVO dis = disaster.toCommandVO();
				dis.setPileList(pileList);
				dis.setDisasterState(Globals.POINT);
				voList.add(dis);
			}
		}

		return ServiceTool.buildSuccessResult(voList);
	}
}
