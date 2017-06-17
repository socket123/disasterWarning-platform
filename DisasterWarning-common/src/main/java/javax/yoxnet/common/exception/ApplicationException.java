package javax.yoxnet.common.exception;


/**
 * 应用级别异常定义。
 * 
 * @author Aaron
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = -418389432305176131L;

    public ApplicationException() {
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(String message, Throwable e) {
        super(message, e);
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(Throwable t) {
        super(t);
        // TODO Auto-generated constructor stub
    }

}
