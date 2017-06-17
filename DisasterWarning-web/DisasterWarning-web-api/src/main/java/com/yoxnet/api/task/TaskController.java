package com.yoxnet.api.task;

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
import com.yoxnet.task.service.SysTaskService;
import com.yoxnet.user.bean.User;

/**   
* @Title: GpsController.java 
* @Description: gps定位处理
* ----------------------------------------------------------------------------
*/
@RestController
public class TaskController extends BaseAction {

	@Autowired
	private SysTaskService sysTaskService;
	
	/**
	* @Description: 查询任务接口
	* @param gps
	* @return
	*/
	@RequestMapping(value="/getTaskInfo",method=RequestMethod.POST)
	public JsonResult<Object> getLogList(@RequestBody User user){
		JsonResult<Object> jr = new JsonResult<Object>();
		
		try {
			ServiceResult<Object> sr = sysTaskService.getTaskList(user.getName(),user.getCreateTime());
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
