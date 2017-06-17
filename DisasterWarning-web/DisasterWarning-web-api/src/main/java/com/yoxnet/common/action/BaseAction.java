/**   
 * @Title: BaseAction.java 
 * @version V1.0   
 */
package com.yoxnet.common.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSONException;
import com.yoxnet.common.code.CodeE;
import com.yoxnet.common.constant.C;
import com.yoxnet.common.json.JSONOuter;
import com.yoxnet.common.json.JsonResult;
import com.yoxnet.common.session.UserSession;

/**
 * 控制层基
 * @ClassName: BaseAction
 * @Description: BaseAction工具
 * @author 
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked"})
public class BaseAction {
	
	protected  Logger logger = LoggerFactory.getLogger(BaseAction.class);
	
	protected HttpServletRequest request;
	
    protected HttpServletResponse response;
    
    private UserSession userSession;
    
    /** 
	* @Title:getCurrentUser 
	* @Description:获取当前用户
	* @author:
	* @param:无
	* @return:UserSession
	* @throws 
	*/
    public UserSession getCurrentUser() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}



	@ModelAttribute 
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){ 
        this.request = request; 
        this.response = response; 
        
    } 
    
	public <T> JsonResult<Object> buildJsonResult(T obj){
        return  new JsonResult(obj,true,C.RETURN_SUCCESS,"成功！");
    }
	
	public <T> JsonResult<T> buildJsonResult(T obj,Map<String, Map<String, String>> dictMap){
        return  new JsonResult(obj,true,C.RETURN_SUCCESS,"成功！",dictMap);
    }
	
	
	public <T> JsonResult<T> buildJsonResult(T obj, String code){
        return new JsonResult(obj, code);
    }
	
	public <T> JsonResult<T> buildJsonResult(T obj, String code, String message){
        return new JsonResult(obj, code, message);
    }
	
	public <T> JsonResult<T> buildJsonResult(T obj,Boolean success, String code, String message){
        return new JsonResult(obj,success, code,message);
    }
	
	public <T> JsonResult<T> buildFailJsonResult(Boolean success,String code, String message){
        return new JsonResult(success,code, message);
    }
	
	public <T> JsonResult<T> buildFailJsonResult(Boolean success,CodeE codeE){
        return new JsonResult(success,codeE.getCode(), codeE.getName());
    }
	
	public <T> void buildJsonResultAndWrite(T obj){
		JsonResult jsonResult = new JsonResult(obj,true,"成功！");
         try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	public <T> void buildJsonResultAndWrite(T obj, String code){
		JsonResult jsonResult = new JsonResult(obj, code);
		try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	public <T> void buildJsonResultAndWrite(T obj, String code, String message){
		JsonResult jsonResult = new JsonResult(obj, code, message);
		try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	public <T> void buildJsonResultAndWrite(T obj,Boolean success, String code, String message){
		JsonResult jsonResult = new JsonResult(obj,success, code, message);
		try {
			JSONOuter.write(response.getWriter(), jsonResult);
		} catch (IOException e) {
			throw new JSONException(e.getMessage(), e);
		}
    }
	
	/**
     * 获取客户端真实IP地址
     *
     * @return IP
     */
    public String getClientIp() {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	
	/**
     * 获取客户端真实IP地址
     *
     * @param request HttpServletRequest
     * @return IP
     */
    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean isUnAvailableIp(String ip) {
        return (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip));
    }
}
