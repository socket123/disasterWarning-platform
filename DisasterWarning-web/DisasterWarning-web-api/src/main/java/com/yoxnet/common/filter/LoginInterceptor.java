/**
 * 
 */
package com.yoxnet.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yoxnet.common.ErrCodeEWeb;
import com.yoxnet.common.action.BaseAction;
import com.yoxnet.common.cache.Cache;
import com.yoxnet.common.consts.WebConst;
import com.yoxnet.common.json.JsonResult;
import com.yoxnet.common.session.UserSession;

/**
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	

	@Override
	public boolean preHandle(HttpServletRequest request
			, HttpServletResponse response,
			Object handler) throws Exception {
		String token = request.getHeader("token");
		Object redisObj=Cache.get(WebConst.PUBLIC_MODEL_PREFIX + "app" + token);
		
		if(null==redisObj){
			this.outWriteError(response);
			return false;
		}
		
		UserSession userSession=(UserSession)redisObj;
		if(StringUtils.isNotBlank(userSession.getToken())&&userSession.getToken().equals(token)){
			
			 if(handler instanceof HandlerMethod){  
		            HandlerMethod method = (HandlerMethod)handler;  
		            Object obj1=method.getBean();
		            BaseAction ba=  (BaseAction)obj1;
		            ba.setUserSession(userSession);
			 }
			return true;
		}else{
			this.outWriteError(response);
			return false;	
		}
	/*	// 获取参数
		String loginName = request.getHeader("loginName");
		String token = request.getHeader("token");
		// 缓存中获取用户登陆凭证
		Object redisObj=RedisUtil.get(WebConst.PUBLIC_MODEL_PREFIX+token+"."+loginName);
		if(null==redisObj){
			this.outWriteError(response);
			return false;	
		}
			
		UserSession userSession=(UserSession)redisObj;
		if(StringUtils.isNotBlank(userSession.getToken())&&userSession.getToken().equals(token)){
			
			 if(handler instanceof HandlerMethod){  
		            HandlerMethod method = (HandlerMethod)handler;  
		            Object obj1=method.getBean();
		            BaseAction ba=  (BaseAction)obj1;
		            ba.setUserSession(userSession);
			 }

			return true;
		}else{
			this.outWriteError(response);
			return false;	
		}*/
		
		
		
		/*UserSession userSession=new UserSession();
		userSession.setId("测试id");
		userSession.setLoginName("模拟登录名");
		userSession.setNikename("模拟昵称");
		userSession.setSysFlag(WebConst.PC_USER_PREFIX);
		 if(handler instanceof HandlerMethod){  
	            HandlerMethod method = (HandlerMethod)handler;  
	            Object obj1=method.getBean();
	            BaseAction ba=  (BaseAction)obj1;
	            ba.setUserSession(userSession);
		 }
		return true;*/
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}
	//登录失败
	private void outWriteError(HttpServletResponse response) throws Exception{
		JsonResult result = new JsonResult();
		result.setCode(ErrCodeEWeb.NO_LOGIN.getCode());
		result.setMessage(ErrCodeEWeb.NO_LOGIN.getName());
		result.setSuccess(Boolean.FALSE);
		result.setData(null);
		String jsonStr = JSONObject.toJSONString(result);
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonStr);
	}
}