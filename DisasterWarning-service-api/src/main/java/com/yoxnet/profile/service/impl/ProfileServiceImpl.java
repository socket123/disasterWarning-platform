package com.yoxnet.profile.service.impl;


import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;

import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.constant.Globals;
import com.yoxnet.common.utils.DateUtiler;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;
import com.yoxnet.kilometerPileInfo.service.KilometerPileInfoService;
import com.yoxnet.pathProfile.bean.PathProfile;
import com.yoxnet.pathProfile.service.PathProfilrService;
import com.yoxnet.profile.service.ProfileService;

import com.yoxnet.profile.vo.ProfileVO;
import com.yoxnet.task.bean.SysTask;
import com.yoxnet.task.service.SysTaskService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.yoxnet.common.exception.BusinessException;
import java.util.ArrayList;
import java.util.List;


@Service("ProfileService")
public class ProfileServiceImpl implements ProfileService {

	private final static Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

	@Resource
	private PathProfilrService pathProfilrService;


	@Resource
	private SysTaskService sysTaskService;



	@Resource
	private KilometerPileInfoService pileInfoService;


	@Override
	public ServiceResult<Object> getPathProfile(ProfileVO profileVO) {

		String taskName = profileVO.getTaskName();
		String time = profileVO.getStartTime();

		if(StringUtils.isEmpty(taskName)){
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}

		if(StringUtils.isEmpty(time)){
			time = DateUtiler.getNow();
		}


		//线状灾害数据查询
		List<PathProfile> PathProfileList =  (List<PathProfile>) pathProfilrService.getByLinearDisaster(taskName,time).getResult();

		List<ProfileVO> voList =  new ArrayList<ProfileVO>();

		if(CollectionUtils.isNotEmpty(PathProfileList)){

			for(PathProfile disaster:PathProfileList){
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
				//根据任务名查询对应任务详细信息
				List<SysTask> task = (List<SysTask>) sysTaskService.getByName(taskName).getResult();
				ProfileVO dsis = disaster.toCommandVO();
				for(SysTask sysTask : task){
					dsis.setDisasterLevel(sysTask.getTaskDescribe());
				}
				dsis.setPileList(pileList);
				dsis.setDisasterState(Globals.LINEAR);
				voList.add(dsis);
			}

		}




		return ServiceTool.buildSuccessResult(voList);
	}

}
