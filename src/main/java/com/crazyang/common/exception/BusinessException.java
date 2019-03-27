package com.crazyang.common.exception;

import com.crazyang.common.enums.ResultEnum;

import java.io.Serializable;

public class BusinessException extends RuntimeException implements Serializable {

private static final long serialVersionUID = 1L;
	
    private String msg;
    private Integer code;
    
    public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public BusinessException(ResultEnum resultEnum){
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	
	public BusinessException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public BusinessException(int code,String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public BusinessException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
