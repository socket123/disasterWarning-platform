package com.yoxnet.common;

import com.yoxnet.common.code.CodeE;

/**
 * @author Administrator
 *
 */
public enum ErrCodeEWeb  implements CodeE{
	
	/**
	 *枚举name规范：模块名（大写）_xxx。比如：USER_xxx,
	 *错误码规范：
	 *W_1XXXXX：公共错误
	 *W_2XXXXX：用户模块
	 *W_6XXXXX：权限模块
	 *W_CXXXXX：数据字典模块
	 */
	/**公共模块*/
	SUCCESS("0", "成功"),
	PARAM_INVALID("W_100001", "参数无效"),
	//SELECT_ERROR("100002", "查询错误"),
	NONE("W_100003", "未知错误"),
	NO_LOGIN("W_100004", "用户未登录或登录超时，请登录！"),
	NO_REDIS("W_100005","退出异常"),
	/**用户模块*/
	
	/**文档管理模块*/
	DOC_UPLOAD("W_500000","上传文件失败"),
	/**权限模块*/
	PERMISSION_CAPTCHA("W_600000","验证码错误,请重试"),
	PERMISSION_USERNAMENOT("W_600001","用户名不存在"),
	PERMISSION_USERPWDERROR("W_600002","用户密码错误"),
	PERMISSION_MOBILENOT("W_600003","手机号不存在"),
	PERMISSION_SMSCODE("W_600004","短信验证码无效"),
	
	
	
	/**数据字典模块*/
	DICT_SYNCHRO_ERROR("W_C00001","同步缓存失败！"),
	DICT_SELECT_ERROR("W_C00002","查询数据字典失败！");
	
	private String code;
	private String name;

	private ErrCodeEWeb(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}
	
	

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  ErrCodeEWeb getCode(String code) {
		ErrCodeEWeb[] opCodes = ErrCodeEWeb.values();
		for (ErrCodeEWeb opCode : opCodes) {
			if (opCode.code.equals(code))
				return opCode;
		}
		return SUCCESS;
	}
}
