
package com.yoxnet.common;

import com.yoxnet.common.constant.C;

/**
 * 通用的service返工具类.
 * 
 * @author 
 */
public class ServiceToolG2<T>  implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*private  ServiceToolG2<T> instance=null;
	
	public   ServiceToolG2<T> getInstance(){
		if(null==instance){
			return new ServiceToolG2<T>();
		}
		return instance;
	}*/
	

	/**
     * 返回成功信息
     * @param obj
     * @return
     */
    public  ServiceResult<T> buildSuccessResult(T obj){
    	ServiceResult<T> result = new ServiceResult<T>();
        result.setResult(obj);
        result.setCode(C.RETURN_SUCCESS);
        result.setErrMsg(null);
        return result;
    }
    
    /**
	 * 封装结构集数据
     * @param <T>
     * @param <T>
	 * @param code
	 * @param msg
	 * @param obj
	 * @return
	 */
    public  ServiceResult<T> buildSuccessResult(String code, String msg, T obj){
		ServiceResult<T> result = new ServiceResult<T>();
        result.setResult(obj);
        result.setCode(code);
        result.setErrMsg(msg);
        return result;
	}
	
    /**
     * 返回应用错误信息，包含网络和数据库错误，runtime异常等
     * @param msg
     * @return
     */
    public  ServiceResult<T> buildApplicationFailResult(String ... msg){
    	ServiceResult<T> result = new ServiceResult<T>();
        result.setResult(null);
        result.setCode(C.RETURN_APPLICATION_FAILURE);
        result.setErrMsg(buildString(msg));
        return result;
    }
    /**
     * 返回业务逻辑错误信息，包含参数错误等
     * @param msg
     * @return
     */
    public  ServiceResult<T> buildBusinessFailResult(String ... msg){
    	ServiceResult<T> result = new ServiceResult<T>();
        result.setResult(null);
        result.setCode(C.RETURN_BUSINESS_FAILURE);
        result.setErrMsg(buildString(msg));
        return result;
    }

    /**
     * 字符串链接
     * @param str
     * @return
     */
    public static String buildString(String ...str){
        StringBuilder buf = new StringBuilder();
        for(String s:str){
            buf.append(s);
        }
        return buf.toString();
    }
    

	
}
