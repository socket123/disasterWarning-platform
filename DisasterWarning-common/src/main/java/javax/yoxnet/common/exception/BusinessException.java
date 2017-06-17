package javax.yoxnet.common.exception;

/**
 * 业务级别异常定义。
 * 
 * @author 
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -418389432305176131L;
    private String code;
    
    public BusinessException() {
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String message) {//{errorCode:00001,message:"kdjaeie"}
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String code,String message) {
    	super(message);
    	this.code=code;
    }

    
    public BusinessException(String message, Throwable e) {
        super(message, e);
        // TODO Auto-generated constructor stub
    }
    
    public BusinessException(String code,String message, Throwable e) {
    	super(message, e);
    	this.code=code;
    }

    public BusinessException(Throwable t) {
        super(t);
        // TODO Auto-generated constructor stub
    }

	public String getCode() {
		return code;
	}

}
