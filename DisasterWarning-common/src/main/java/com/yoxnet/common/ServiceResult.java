
package com.yoxnet.common;

/**
 * 通用的service返回结果.
 * 
 * @author 
 */
public class ServiceResult<T>  implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7402793522023784869L;

	/**
     * 操作结果
     *
     * @see ServiceConst.gooday.service.common.ServiceConstants
     */
    private String code;

    /**
     * 错误信息,如果code是出错，则错误具体提示存在此处
     */
    private String errMsg;

    /**
     * 返回的结果
     */
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
