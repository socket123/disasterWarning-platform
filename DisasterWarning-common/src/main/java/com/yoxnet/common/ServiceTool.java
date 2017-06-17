package com.yoxnet.common;

import javax.yoxnet.common.exception.BusinessException;

import com.yoxnet.common.code.CodeE;
import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.common.constant.C;

/**
 * 通用的service返工具类.
 * 
 * @author 
 */
public class ServiceTool{
    /**
     * 返回成功信息
     * @param obj
     * @return
     */
    public static ServiceResult<Object> buildSuccessResult(Object obj){
        ServiceResult<Object> result = new ServiceResult<Object>();
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
    public static ServiceResult<Object> buildSuccessResult(String code, String msg, Object obj){
		ServiceResult<Object> result = new ServiceResult<Object>();
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
    public static ServiceResult<Object> buildApplicationFailResult(String ... msg){
        ServiceResult<Object> result = new ServiceResult<Object>();
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
    public static ServiceResult<Object> buildBusinessFailResult(String ... msg){
        ServiceResult<Object> result = new ServiceResult<Object>();
        result.setResult(null);
        result.setCode(C.RETURN_BUSINESS_FAILURE);
        result.setErrMsg(buildString(msg));
        return result;
    }
    
    /**
     * 返回业务逻辑错误信息，包含参数错误等
     * @param msg
     * @return
     */
    public static ServiceResult<Object> buildBusinessFailResult(String code,String msg){
        ServiceResult<Object> result = new ServiceResult<Object>();
        result.setResult(null);
        result.setCode(code);
        result.setErrMsg(buildString(msg));
        return result;
    }
    
    /**
     * 返回业务逻辑错误信息，包含参数错误等
     * @param msg
     * @return
     */
    public static ServiceResult<Object> buildBusinessFailResult(CodeE codeE){
        ServiceResult<Object> result = new ServiceResult<Object>();
        result.setResult(null);
        result.setCode(codeE.getCode());
        result.setErrMsg(buildString(codeE.getName()));
        return result;
    }

    /**
     * 返回业务逻辑错误信息，包含参数错误等
     * @param Exception e
     * @param CodeE codeE   如果 入参e找不到错误信息和错误码，则采用该参数的错误信息和错误码
     * @return ServiceResult，如果入参是BusinessException，则错误信息和错误码是BusinessException自带的。否则，是CodeE的
     */
    public static ServiceResult<Object> buildBusinessFailResult(Exception e,CodeE codeE){
    	ServiceResult<Object> sr=new ServiceResult<Object>();
    	if(e instanceof BusinessException){
    		BusinessException be=(BusinessException) e;
			sr= buildBusinessFailResult(be.getCode(),be.getMessage());	
		}else{
			sr= buildBusinessFailResult(codeE);	
		}
        return sr;
    }
    
    /**
     * 字符串链接
     * @param str
     * @return
     */
    private static String buildString(String ...str){
        StringBuilder buf = new StringBuilder();
        for(String s:str){
            buf.append(s);
        }
        return buf.toString();
    }
    
    private static void test(){


    	//throw new BusinessException("111014","查询错误");
    }
    public static void main(String[] args) {
		
    	try {
			test();
		} catch (Exception e1) {
			ServiceTool.buildBusinessFailResult(e1, ErrCodeE.DB_ERROR);
		}
    	
    	
	}
    
}
