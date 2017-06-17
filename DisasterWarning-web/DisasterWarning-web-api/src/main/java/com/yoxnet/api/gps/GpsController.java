package com.yoxnet.api.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoxnet.common.ErrCodeEWeb;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.action.BaseAction;
import com.yoxnet.common.constant.C;
import com.yoxnet.common.json.JsonResult;
import com.yoxnet.gps.service.GpsService;
import com.yoxnet.task.bean.SysTask;
import com.yoxnet.user.bean.User;

/**   
* @Title: GpsController.java 
* @Description: gps定位处理
* ----------------------------------------------------------------------------
*/
@RestController
public class GpsController extends BaseAction {

	@Autowired
	private GpsService gpsService;
	
	/**
	* @Description: gps定位接口（老接口搁置）
	* @param gps
	* @return
	*/
	@RequestMapping(value="/getGpsInfo",method=RequestMethod.POST)
	public JsonResult<Object> getGpsInfo(@RequestBody User user){
		JsonResult<Object> jr = new JsonResult<Object>();
		
		try {
			ServiceResult<Object> sr = gpsService.getGps(user);
			 if (C.RETURN_SUCCESS.equals(sr.getCode())) {
	                jr = buildJsonResult(sr.getResult());
	          } else {
	                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
	          }
		} catch (Exception e) {
			jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
		}
		return jr;
	}
	
	/**
	* @Description: gps定位接口（新接口定位根据任务名进行单点定位）
	* @param gps
	* @return
	*/
	@RequestMapping(value="/getGpsByTask",method=RequestMethod.POST)
	public JsonResult<Object> getGpsByTask(@RequestBody SysTask sysTask){
		JsonResult<Object> jr = new JsonResult<Object>();
		
		try {
			ServiceResult<Object> sr = gpsService.getGpsByTask(sysTask);
			 if (C.RETURN_SUCCESS.equals(sr.getCode())) {
	                jr = buildJsonResult(sr.getResult());
	          } else {
	                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
	          }
		} catch (Exception e) {
			jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
		}
		return jr;
	}
}
