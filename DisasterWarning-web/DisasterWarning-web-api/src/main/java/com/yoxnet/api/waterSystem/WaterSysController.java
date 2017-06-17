package com.yoxnet.api.waterSystem;

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
import com.yoxnet.waterSystem.service.WaterSystemService;
import com.yoxnet.waterSystem.vo.WaterSysVO;

/**   
* @Title: WaterSysController.java 
* @Description: 水系统处理类
* ----------------------------------------------------------------------------
*/
@RestController
public class WaterSysController extends BaseAction {

	@Autowired
	private WaterSystemService waterSystemService;
	
	/**
	* @Description: 水系信息接口
	* @param gps
	* @return
	*/
	@RequestMapping(value="/getWaterSystemInfo",method=RequestMethod.POST)
	public JsonResult<Object> getWaterSystemInfo(@RequestBody WaterSysVO waterSysVO){
		JsonResult<Object> jr = new JsonResult<Object>();
		
		try {
			ServiceResult<Object> sr = waterSystemService.getWaterSys(waterSysVO);
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
