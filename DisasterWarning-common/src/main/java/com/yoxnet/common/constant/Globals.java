package com.yoxnet.common.constant;

/** 
 * @ClassName:	Globals 
 * @Description:全局变量
 *  
 */
public class Globals {
	/**
	 * 保存用户到SESSION
	 */
	public static String USER_SESSION="USER_SESSION";
	
	public static String OPC_ADMIN = "superAdmin";
	
	public static final String USER_PRUVIEW_TREE = "USER_PRUVIEW_TREE";
	
	public static final String SYSTEM_ADMIN = "0";

	/**---------日志操作类型---------------*/
	// 1.新增 2.修改 3.删除 4.其他
	public static final String OPERATE_TYPE_ADD = "1";
	
	public static final String OPERATE_TYPE_UPDATE = "2";
	
	public static final String OPERATE_TYPE_DELETE = "3";
	
	public static final String OPERATE_TYPE_OTHER = "4";
	
	
	/**------------------模块名称-----------*/
	
	public static final String MODULE_ADMIN = "系统用户";
	
	public static final String MODULE_SYSTEM_OPC = "opc";
	
	public static final String MODULE_MENU = "菜单";
	
	public static final String MODULE_ROLE = "角色";
	
	public static final String MODULE_APPUSER = "app用户";
	
	public static final String MODULE_EAM_WAITLIST = "EAM待办列表";
	
	public static final String MODULE_EAM_LOGMASTER = "EAM日志主表";
	
	public static final String MODULE_EAM_USER = "EAM用户";
	
	/**-----------------日志结果------------*/
	
	public static final String NODE_SUCCESS = "成功!";
	public static final String NODE_FAILE = "失败!";
	
	/**-----------------灾害类型------------*/
	
	public static final String LINEAR = "linear";  	//线状灾害
	public static final String POINT = "point";		//点状灾害
}
