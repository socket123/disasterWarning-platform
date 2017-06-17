package com.yoxnet.common.constant;

import com.yoxnet.api.util.JsonUtil;

/**
 * <strong>Title : ResponseEntity </strong>. <br>
 * <strong>Description : http接口响应实体类.</strong> <br>
 * <strong>Create on : Mar 23, 2016 2:15:32 PM </strong>. <br>
 * <p>
 * <strong>Copyright (C) YOX Internet Technology Co.,Ltd.</strong> <br>
 * </p>
 * @author k2 <br>
 * @version <strong>base-platform-0.1.0</strong> <br>
 * <br>
 * @see
 * <br>
 */
public class ResponseEntity {

	private boolean success; // 是否成功
	private String errmsg; // 错误内容
	private String errcode; // 错误代码
	private Object data; // 数据对象
	private String successMsg;

	/**
	 * @author by K2 Mar 24, 2016
	 *
	 * @desc 构造函数.
	 * @param success
	 * @param data
	 * @param errcode
	 * @param errmsg
	 */
	public ResponseEntity(boolean success, Object data, String errcode, String errmsg) {
		this.success = success;
		this.data = data;
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	/**
	 * @author by K2 Mar 24, 2016
	 *
	 * @desc 构造函数.
	 * @param errcode
	 * @param errmsg
	 */
	public ResponseEntity(String errcode, String errmsg) {
		this.success = false;
		this.data = null;
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	
	public ResponseEntity(Object data, String successMessage) {
		this.success = true;
		this.data = data;
		this.errcode = null;
		this.successMsg = successMessage;
	}

	/**
	 * @author by K2 Mar 24, 2016
	 *
	 * @desc 构造函数.
	 * @param data
	 */
	public ResponseEntity(Object data) {
		this.success = true;
		this.data = data;
	}


	/**
	 * @author by K2 Mar 24, 2016
	 *
	 * @desc 将ResponseEntity转换成json格式对象.
	 * @return
	 */
	public Object toJson(){
		return JsonUtil.toJson(this);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}


	
}
