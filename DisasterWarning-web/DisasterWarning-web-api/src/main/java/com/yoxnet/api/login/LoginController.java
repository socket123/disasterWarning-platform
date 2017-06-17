package com.yoxnet.api.login;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.constant.C;
import com.yoxnet.disaster.service.DisasterService;
import com.yoxnet.disaster.vo.DisasterVO;
import com.yoxnet.gps.bean.GpsHttp;
import com.yoxnet.gps.bean.GpsInfo;
import com.yoxnet.gps.service.GpsService;
import com.yoxnet.points.service.PointesService;
import com.yoxnet.points.vo.PointesVO;
import com.yoxnet.profile.service.ProfileService;
import com.yoxnet.profile.vo.ProfileVO;
import com.yoxnet.role.bean.SysRole;
import com.yoxnet.task.bean.SysTask;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoxnet.common.ErrCodeEWeb;
import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.action.BaseAction;
import com.yoxnet.common.cache.Cache;
import com.yoxnet.common.consts.WebConst;
import com.yoxnet.common.json.JsonResult;
import com.yoxnet.common.session.UserSession;
import com.yoxnet.common.utils.MD5;
import com.yoxnet.common.utils.Stringer;
import com.yoxnet.user.bean.User;
import com.yoxnet.user.service.SysUserService;

import net.sf.json.JSONObject;

import javax.yoxnet.common.exception.BusinessException;

/**   
* @Title: LoginController.java 
* @Description: 登录
*  1.0         2016年11月22日        Aaron              登录
*/
@RestController
public class LoginController extends BaseAction {
	
	private String loginPassword;// 登录来源
	private String loginName;// 登录名称
	private String token;// 生成token
	private String key;// key
	
	@Autowired
	private SysUserService userService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private PointesService pointesService;


	@Autowired
	private GpsService gpsService;

	/***
	 *   获取数据 gps
	 * @return
	 * ,method=RequestMethod.POST
	 */
	@RequestMapping(value="/getcarGps")
	public JsonResult<Object> getcarGps(@RequestBody SysTask sysTask) {
		JsonResult<Object> jr = new JsonResult<Object>();
//		sysTask.setTaskName("陕2调研");
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

	/**
	 * @Description: 隐患点  点状显示
	,method=RequestMethod.POST
	 * @return
	 *
	 */
	@RequestMapping(value="/getPoites")
	public JsonResult<Object> getPoites(@RequestBody PointesVO pointesVO){
		JsonResult<Object> jr = new JsonResult<Object>();
//		pointesVO.setTaskName("陕2调研");
		try {
			ServiceResult<Object> sr = pointesService.getDisaster(pointesVO);
			if (C.RETURN_SUCCESS.equals(sr.getCode())) {
				jr = buildJsonResult(sr.getResult());
				System.out.println("隐患点 显示");
			} else {
				jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
			}

		} catch (Exception e) {
			jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
		}
		return jr;
	}

	/**
	 * @Description: 隐患点  线状显示
	,method=RequestMethod.POST
	 * @return
	 *
	 */
	@RequestMapping(value="/getPoites_linner",method=RequestMethod.POST)
	public JsonResult<Object> getPoites_linner(@RequestBody PointesVO pointesVO){
		JsonResult<Object> jr = new JsonResult<Object>();
//		pointesVO.setTaskName("沈阳 ~ 胜利变电站");
		try {
			ServiceResult<Object> sr = pointesService.getDisaster_liness(pointesVO);
			if (C.RETURN_SUCCESS.equals(sr.getCode())){
				jr = buildJsonResult(sr.getResult());
				System.out.println("隐患线状显示");
			} else {
				jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
			}

		} catch (Exception e) {
			jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
		}
		return jr;
	}

	/***
	 *   道路概况 线路
	 * @param profileVO
	 * @return
	 * ,method=RequestMethod.POST
     */
	@RequestMapping(value="/getPathProfile")
	public JsonResult<Object> getPathProfile(@RequestBody ProfileVO profileVO){
		JsonResult<Object> jr = new JsonResult<Object>();
		try {
			ServiceResult<Object> sr = profileService.getPathProfile(profileVO);
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

	//,method=RequestMethod.POST
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public JsonResult<Object> login(String loginName,String password){
		UserSession userSession = null;
		try {
			ServiceResult<Object> s = userService.getByName(loginName);
			User user = (User) s.getResult();
			if(!Stringer.isNullOrEmpty(user)){
				if(user.getPassword().equals(password)){
					this.loginName = user.getName();
					this.loginPassword = user.getPassword();
					userSession = new UserSession();
					userSession.setLoginName(user.getName());
					
					this.token = this.getToken();
					userSession.setToken(this.token);
					
					Object session = userSession;
					
					Cache.put(this.getKey(), session, 30, TimeUnit.DAYS);
					
					LoginResult loginResult = new LoginResult();
					loginResult.setId(user.getId());
					loginResult.setToken(this.token);
					return buildJsonResult(loginResult);
				}else{
					return buildFailJsonResult(false,ErrCodeEWeb.PERMISSION_USERPWDERROR.getCode(), ErrCodeEWeb.PERMISSION_USERPWDERROR.getName());
				}
			}else{
				return buildFailJsonResult(false,ErrCodeEWeb.PERMISSION_USERPWDERROR.getCode(), ErrCodeEWeb.PERMISSION_USERPWDERROR.getName());
			}
		} catch (Exception e) {
			return buildFailJsonResult(false,ErrCodeEWeb.PERMISSION_USERPWDERROR.getCode(), ErrCodeEWeb.PERMISSION_USERPWDERROR.getName());
		}
	}
	
	
	@RequestMapping(value="/layout",method=RequestMethod.GET)
	public JsonResult<Object> layout(){
		try {
			UserSession userSession = getCurrentUser();
			Cache.remove(WebConst.PUBLIC_MODEL_PREFIX+"app"+userSession.getToken());
//			RedisUtil.remove(WebConst.PUBLIC_MODEL_PREFIX+"app"+userSession.getToken());
			return buildJsonResult(null);
		} catch (Exception e) {
			return buildFailJsonResult(false,ErrCodeEWeb.PERMISSION_USERPWDERROR.getCode(), ErrCodeEWeb.PERMISSION_USERPWDERROR.getName());
		}
	}
	
	public String getToken() {
		token = MD5.encodeMD5(this.loginPassword + this.loginName + System.currentTimeMillis());
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getKey() {
		key = WebConst.PUBLIC_MODEL_PREFIX+"app" + this.token;
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
