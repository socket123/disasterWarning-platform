package com.yoxnet.common.consts;

import com.yoxnet.common.constant.C;

public interface WebConst extends C {

	/*************redis key 常量*************/
	/**
	 * 用户前缀标识-后台
	 */
	public static final String INNER_USER_PREFIX = "M"; 
	/**
	 * 用户前缀标识-公共模块
	 */
	public static final String PUBLIC_MODEL_PREFIX = "comm."; 
	
	
	/**
	 * 超时时间,单位秒
	 */
	public static final long REDIS_EXPIRE =18000;
	
	
}