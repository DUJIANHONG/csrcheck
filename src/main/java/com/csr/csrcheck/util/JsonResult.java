package com.csr.csrcheck.util;

import java.io.Serializable;

/**
 * 封装响应的JSON结果的类
 */
public class JsonResult<T> implements Serializable {

	private static final long serialVersionUID = -3675277270614887834L;
	
	private Integer code;
	private String msg;
	private T data;

	public JsonResult() {
		super();
	}

	public JsonResult(Integer code,String msg) {
		super();
		this.code = code;
		this.msg=msg;
	}

	public JsonResult(Throwable e) {
		super();
		this.msg = e.getMessage();
	}

	public JsonResult(Integer code, String msg,T data) {
		super();
		this.code = code;
		this.msg=msg;
		this.data = data;
	}

	public Integer getcode() {
		return code;
	}

	public void setcode(Integer code) {
		this.code = code;
	}

	public String getmsg() {
		return msg;
	}

	public void setmsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
