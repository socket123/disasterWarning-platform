package com.yoxnet.gps.service;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.gps.bean.GpsInfo;
import com.yoxnet.task.bean.SysTask;
import com.yoxnet.user.bean.User;

/**
 * @author 
 *
 */
public interface GpsService {
	
	/**
     * @Description getGps 获取Gps定位信息
     * 
     */
	public ServiceResult<Object> getGps (User User);
	
	/**
	* @Description: gps定位接口（新接口定位根据任务名进行单点定位）
	*/
	public ServiceResult<Object> getGpsByTask(SysTask sysTask);
	
	
}

