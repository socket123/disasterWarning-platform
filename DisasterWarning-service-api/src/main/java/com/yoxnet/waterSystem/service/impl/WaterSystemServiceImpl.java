package com.yoxnet.waterSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.utils.DateUtiler;

import javax.annotation.Resource;
import javax.yoxnet.common.exception.BusinessException;

import com.yoxnet.waterSystem.service.WaterSystemService;
import com.yoxnet.waterSystem.vo.WaterSysVO;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrology;
import com.yoxnet.waterSystemHydrology.service.WaterSystemHydrologyService;
import com.yoxnet.waterSystemInfo.bean.WaterSystemInfo;
import com.yoxnet.waterSystemInfo.service.WaterSystemInfoService;
import com.yoxnet.waterSystemLocation.bean.WaterSystemLocation;
import com.yoxnet.waterSystemLocation.service.WaterSystemLocationService;


@Service("WaterSystemService")
public class WaterSystemServiceImpl implements WaterSystemService {

	private final static Logger logger = LoggerFactory.getLogger(WaterSystemServiceImpl.class);

	@Resource
	private WaterSystemHydrologyService waterSystemHydrologyService;
	
	@Resource
	private WaterSystemInfoService waterSystemInfoService;
	
	@Resource
	private WaterSystemLocationService waterSystemLocationService;

	@Override
	public ServiceResult<Object> getWaterSys(WaterSysVO waterSysVO) {

		String time = waterSysVO.getTime();
		String task = waterSysVO.getTaskName();
		
		if(StringUtils.isEmpty(time)){
			time = DateUtiler.getNow();
		}
		
		if(StringUtils.isEmpty(task)){
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		
		List<WaterSysVO> voList = new ArrayList<WaterSysVO>();
		
		List<WaterSystemHydrology> hydrologyList =  (List<WaterSystemHydrology>) waterSystemHydrologyService.getWaterSystemHydrology(time).getResult();
		
		if(CollectionUtils.isEmpty(hydrologyList)){
			return	ServiceTool.buildSuccessResult(null);
		}
		
		for(WaterSystemHydrology hydrology:hydrologyList){
			
			WaterSystemInfo waterSystemInfo = (WaterSystemInfo) waterSystemInfoService.getWaterSystemInfo(hydrology.getWaterSysId()).getResult();
			
			List<WaterSystemLocation> locationList =  (List<WaterSystemLocation>) waterSystemLocationService.getWaterSystemLocation(hydrology.getWaterSysId()).getResult();
		
			String[] times = hydrology.getTime().split(" ");
			
			hydrology.setTime(times[0]);
			
			WaterSysVO vo = hydrology.toCommandVO();
			
			vo.setWaterSysName(waterSystemInfo.getWaterSysName());
			
			vo.setFloodLevel(waterSystemInfo.getFloodLevel());
			
			vo.setLocationList(locationList);
			
			if(task.equals(waterSystemInfo.getTaskName())){
				voList.add(vo);
			}
		}
		
		return ServiceTool.buildSuccessResult(voList);
	}
}
