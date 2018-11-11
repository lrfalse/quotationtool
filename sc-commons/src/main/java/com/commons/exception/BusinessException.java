package com.commons.exception;

/**
 * 业务异常，用于抛出给前端提示错误信息
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -695542791928644578L;
    private int status = -2;			//系统异常值
    private Object data;

    public BusinessException(String message) {
        this(message, -2);
    }
	public BusinessException() {
		this("系统处理异常", -2);
	}

    public BusinessException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BusinessException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public BusinessException(String message, Throwable cause, Object data) {
        super(message, cause);
        this.data=data;
    }

    public BusinessException(String message, Throwable cause, int status,Object data) {
        super(message, cause);
        this.status = status;
        this.data=data;
    }

    public Object getData(){
        return this.data;
    }

    public int getStatus() {
        return status;
    }
}
