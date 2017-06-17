package com.yoxnet.common.constant;

/**
 * 全局常量
 */
public interface C{
	
	
	
	public static final int Platform_szds = 1;
	
	/**
	 * 用户id标识：szds【全局id】
	 */
	public static final String PRI_SYS = "szds";
	
	/*=======================全局角色常量==========================*/
	/**
	 * session key
	 * 获取系统用户对象
	 */
	public static final String SYS_USER="sysUser";
	
	
	
	/**
	 * session key
	 * 获取系统SESSION 参数对象
	 * 包含用户id，session的id，角色id集合，按钮权限id集合
	 */
	public static final String SESSION_PARAM="sessionParam";
	
	/**
	 * 系统用户
	 */
	public static final Integer SYSUSER=2;
	
	
	
	

	/**
	 * 文档下载路径:base/getfile/download/
	 */
	public static final String FILE_GET_PATH = "/base/getfile/download/";
	
	/**
	 * 获取文件上传地址用KEY： base_upload_pic
	 */
	public static final String BASE_UPLOAD_PIC = "base_upload_pic";
	
	/**
	 * 获取文件上传地址用KEY： base_upload_file
	 */
	public static final String BASE_UPLOAD_FILE = "base_upload_file";
	
	/**
	 * 图片下载地址：/base/getfile/pic/
	 */
	public static final String BASE_GETFILE_PIC = "/base/getfile/pic/";
	
	/**
	 * 收发文上传文件下载地址用KEY：ft_sfw
	 */
	public static final String BASE_GETFILE_SFW = "ft_sfw";
	

	
	
   
	public static final String RETURN_SUCCESS = "0";
	public static final String RETURN_BUSINESS_FAILURE ="-1" ;//业务错误，业务逻辑错误，包含参数错误
	public static final  String RETURN_APPLICATION_FAILURE ="-2" ;//应用错误，包含runtime异常，网络，数据库异常
	
    /**
	 * 项目统一编码
	 */
	public static final String CHARSET = "UTF-8"; 
	
	
	
	
	/*****************************************系统常量*******************************************************/
	public static final String IS_NOT_READ = "0";//未读
	
	public static final String IS_READ = "1";//已读
	
	public static final String IS_NOT_DELETE = "0";//未删除
	
	public static final String IS_DELETE = "1";//已删除
	
	public static final String PLAT_TYPE_EAM = "0";//EAM
	
	public static final String PLAT_TYPE_SZDS = "1";//szds
	
	public static final String QUARTZ_STATUS_START = "1";//已开启
	
	public static final String QUARTZ_STATUS_STOP = "0";//已停止
	
	public static final String UNIT_SET_ONE = "0";//1#机组
	
	public static final String UNIT_SET_TWO = "1";//2#机组
    
}
