package com.yoxnet.api.disaster;

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
import com.yoxnet.disaster.service.DisasterService;
import com.yoxnet.disaster.vo.DisasterVO;

/**   
* @Title: GpsController.java 
* @Description: 灾害处理类
* ----------------------------------------------------------------------------
*/
@RestController
public class DisasterController extends BaseAction {

	@Autowired
	private DisasterService disasterService;
	
	/**
	* @Description: 灾害信息接口

	* @return
	 *
	*/
	@RequestMapping(value="/getDisasterInfo",method=RequestMethod.POST)
	public JsonResult<Object> getDisasterInfo(@RequestBody DisasterVO disasterVO){
		JsonResult<Object> jr = new JsonResult<Object>();
		try {
			ServiceResult<Object> sr = disasterService.getDisaster(disasterVO);
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
