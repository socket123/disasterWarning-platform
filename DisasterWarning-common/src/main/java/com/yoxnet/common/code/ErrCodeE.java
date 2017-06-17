package com.yoxnet.common.code;


/**
 * @author Administrator
 * desc
 *
 */
public enum ErrCodeE implements CodeE {
	
	/**
	 *
	 *错误码规范：
	 *1XXXXX：公共错误
	 *2XXXXX：用户模块
	 */
	
	/**公共模块*/
	SUCCESS("0", "成功"),
	PARAM_INVALID("100001", "参数无效"),
	DB_ERROR("100002", "数据库错误"),
	NONE("100003", "未知错误"),
	NO_RECORD("100004","无此条记录"),
	NO_ROLE("100005","请选择角色"),
	LOG_ERROR("100006","添加日志失败"),

	/**用户模块*/
	USER_ERRERE("200001","你添加的条数已经超过上限"),
	USER_EXIST("200002","该账号已经存在"),
	
	
	PROPERTIES_INVALID("800001","属性复制异常"),
	TYPE_CONVERT_EXCEPTION("800002","类型转换异常");
	
	/**消息模块*/
	
	/**流程定义模块*/
	
	
	private String code;
	private String name;

	private ErrCodeE(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public  ErrCodeE getCode(String code) {
		ErrCodeE[] opCodes = ErrCodeE.values();
		for (ErrCodeE opCode : opCodes) {
			if (opCode.code.equals(code))
				return opCode;
		}
		return SUCCESS;
	}
}
