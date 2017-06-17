package com.yoxnet.gps.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import net.sf.json.JSONArray;

import com.yoxnet.common.GeneratorKey;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.ServiceTool;
import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.utils.DateUtiler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.yoxnet.common.exception.BusinessException;

import com.yoxnet.gps.bean.GpsHttp;
import com.yoxnet.gps.bean.GpsInfo;
import com.yoxnet.gps.service.GpsService;
import com.yoxnet.locationInfo.bean.DataLocationInfo;
import com.yoxnet.locationInfo.service.DataLocationInfoService;
import com.yoxnet.role.bean.SysRole;
import com.yoxnet.role.service.SysRoleService;
import com.yoxnet.task.bean.SysTask;
import com.yoxnet.task.service.SysTaskService;
import com.yoxnet.user.bean.User;


@Service("gpsService")
public class GpsServiceImpl implements GpsService {

	private final static Logger logger = LoggerFactory.getLogger(GpsServiceImpl.class);
	
	@Resource
	private SysRoleService sysRoleService;
	
	@Resource
	private SysTaskService sysTaskService;
	
	@Resource
	private DataLocationInfoService locationInfoService;
	
	/**
	* @Description: gps定位接口（老接口搁置）
	* @param gps
	* @return
	*/
	@Override
	public ServiceResult<Object> getGps(User user) {
		if (null == user.getName()) {
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		//根据用户名查询对应任务
		List<SysRole> sysRoleList =  (List<SysRole>) sysRoleService.getByName(user.getName()).getResult();
		if(CollectionUtils.isEmpty(sysRoleList)){
			throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		//返回手机端的GPS数据集合
		List<GpsInfo> locationInfo = new ArrayList<GpsInfo>();
		
		for(SysRole role:sysRoleList){
			//根据任务名查询对应任务详细信息
			List<SysTask> sysTask = (List<SysTask>) sysTaskService.getByName(role.getTaskName()).getResult();
			
			for(SysTask task:sysTask){
				//通过任务详细信息中的车辆ID和车辆授权码调用GPS
				JSONArray gpsInfo = GpsHttp.httpGetUtils(task.getDeviceId(),task.getDeviceCode());
				
				if(null == gpsInfo ){
					throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
				}
				
				List<GpsInfo> info = GpsHttp.getBeanList(gpsInfo);
				GpsInfo gpsList = null;
				if(CollectionUtils.isNotEmpty(info)){
					gpsList = info.get(0);
				}
				
				//添加任务名称返回
				gpsList.setTaskName(role.getTaskName());
				
				locationInfo.add(gpsList);
				//定位数据存库
				DataLocationInfo location = new DataLocationInfo();
				location.setId(GeneratorKey.genaraId());
				location.setLatitude(gpsList.getLat()); 
				location.setLongitude(gpsList.getLng());
				location.setTaskName(task.getTaskName());
				location.setTime(DateUtiler.timeMillis2dateString(Long.parseLong(gpsList.getGpstime()), DateUtiler.YYYY_MM_DD_HH_MM_SS));
				
				locationInfoService.save(location);
			}
		}
		
		return ServiceTool.buildSuccessResult(locationInfo);
	}
	
	/**
	* @Description: gps定位接口（新接口定位根据任务名进行单点定位）
	* @param gps
	* @return
	*/
	@Override
	public ServiceResult<Object> getGpsByTask(SysTask sysTask){
		String taskName = sysTask.getTaskName();
		
		//根据任务名查询对应任务详细信息
		List<SysTask> task = (List<SysTask>) sysTaskService.getByName(taskName).getResult();
		
		GpsInfo gpsList = null;
		
		for(SysTask po:task){
			//通过任务详细信息中的车辆ID和车辆授权码调用GPS
			JSONArray gpsInfo = GpsHttp.httpGetUtils(po.getDeviceId(),po.getDeviceCode());
			
			if(null == gpsInfo ){
				throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
			}
			
			List<GpsInfo> info = GpsHttp.getBeanList(gpsInfo);
			if(CollectionUtils.isNotEmpty(info)){
				gpsList = info.get(0);
			}
			
			//添加任务名称返回
			gpsList.setTaskName(sysTask.getTaskName());
			
			//定位数据存库
			DataLocationInfo location = new DataLocationInfo();
			location.setId(GeneratorKey.genaraId());
			location.setLatitude(gpsList.getLat()); 
			location.setLongitude(gpsList.getLng());
			location.setTaskName(taskName);
			location.setTime(DateUtiler.timeMillis2dateString(Long.parseLong(gpsList.getGpstime()), DateUtiler.YYYY_MM_DD_HH_MM_SS));
			
			locationInfoService.save(location);
		}
		
		return ServiceTool.buildSuccessResult(gpsList);
	}

}
