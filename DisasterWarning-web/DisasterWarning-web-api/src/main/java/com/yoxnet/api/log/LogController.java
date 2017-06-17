package com.yoxnet.api.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.yoxnet.common.utils.DateUtiler;
import com.yoxnet.hiddenPoints.dao.HiddenPointsMapper;
import com.yoxnet.log.dao.LogMapper;
import com.yoxnet.task.bean.SysTaskExample;
import com.yoxnet.task.dao.SysTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yoxnet.common.GeneratorKey;
import com.yoxnet.common.action.BaseAction;
import com.yoxnet.common.jpush.PushSender;
import com.yoxnet.common.session.UserSession;
import com.yoxnet.common.utils.Stringer;
import com.yoxnet.log.bean.Log;
import com.yoxnet.log.service.LogService;
import com.yoxnet.role.bean.SysRole;
import com.yoxnet.role.service.SysRoleService;
import com.yoxnet.task.service.SysTaskService;

/**   
* @Title: LogController.java 
* @Description: 推送消息
* ----------------------------------------------------------------------------
*/
@Controller
@RequestMapping("/log")
public class LogController  extends BaseAction{

	private Logger logs = LoggerFactory.getLogger(this.getClass());
	@Resource
	private LogMapper logMapper;
	@Resource
	private HiddenPointsMapper hiddenPointsMapper;

	@Autowired
	private LogService logService;
	
	@Autowired
	SysTaskService sysTaskService;
	
	@Autowired
	SysRoleService sysRoleService;


	@Resource
	private SysTaskMapper sysTaskMapper;

	@RequestMapping("/web/push")
	public  String logPushPage(HttpServletRequest req){
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx====================");
		SysTaskExample example = new SysTaskExample();

		example.createCriteria().andEndTimeGreaterThanOrEqualTo(DateUtiler.getNow());


		req.setAttribute("tasks", sysTaskMapper.selectByExample(example));
	
		
		return "/log/push";
	}
	
	@RequestMapping(value="/web/send",method=RequestMethod.POST)
	@ResponseBody
	public Object sendNotification(Log log,HttpServletRequest req){
		
		logs.debug("=======title:"+log.getLogTitle()+"    taskName:"+log.getTaskName()+"=====content:"+log.getLogContent());
		
		try {
			
			if(Stringer.isNullOrEmpty(log.getLogTitle())){
				
				return buildFailJsonResult(false,"-1","标题不能为空");
			}
			
			
			log.setId(GeneratorKey.genaraId());
			log.setLogTime(new Date());
			hiddenPointsMapper.inserterster(log);
//			logService.save(log);

			List<SysRole> roleList = sysRoleService.findSysRoleByTaskName(log.getTaskName());
			
			List<String> userNames = new ArrayList<>(roleList.size());
			
			for (SysRole sysRole2 : roleList) {
				
				userNames.add(sysRole2.getName());
			}
			
			Map<String, String> extra = new HashMap<>();
			
			extra.put("id", log.getId());
			
			if(Stringer.isNullOrEmpty(log.getTaskName())){
				
				PushSender.sendAllMessageNotice(log.getTaskName(),log.getLogTitle(), extra);
				
				logs.debug("全部发送");
				
			}else{
				
				logs.debug("别名发送"+"size:"+userNames.size());
				
				for (String string : userNames) {
					
					logs.debug(string);
					
				}
				PushSender.sendMessageNotice(userNames, log.getTaskName(),log.getLogTitle(), extra);
			}
	
			return buildJsonResult("成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buildFailJsonResult(false, "-1", "数据异常");
	}


	@RequestMapping("/list")
	@ResponseBody
	public Object logList(String username,Integer page,Integer size){
		
		try {
//			username = "admin";
			UserSession us  =  getCurrentUser();
			if(null == page){
				page = 0 ;
			}
			if(null == size){
				size = 10 ;
			}
			List<Log>  Log =  logMapper.selectAllLogAndOwner(username, page*size, size);
			return buildJsonResult(Log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buildFailJsonResult(false, "-1","异常");
	}
	
	
	/**
	* @Description: 日志列表
	* @param logs
	* @return
	* @author: Aaron
	* @date: 2016年11月23日 下午4:50:11
	*/
	/*@RequestMapping(value="/getLogList",method=RequestMethod.POST)
	public JsonResult<Object> getLogList(@RequestBody Log log){
		JsonResult<Object> jr = new JsonResult<Object>();
		
		try {
			ServiceResult<Object> sr = logService.list(log);
			 if (C.RETURN_SUCCESS.equals(sr.getCode())) {
	                jr = buildJsonResult(sr.getResult());
	          } else {
	                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
	          }
		} catch (Exception e) {
			jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
		}
		return jr;
	}*/
}
