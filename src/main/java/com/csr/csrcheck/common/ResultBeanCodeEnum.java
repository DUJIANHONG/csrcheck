package com.csr.csrcheck.common;

public enum ResultBeanCodeEnum {

	OPERA_SUCCESS(0, "操作成功"),
	OPERA_EXCEPTION(-1, "系统异常"),
	OPERA_FAIL(-2,"操作失败"),
	OPERA_FAIL_WECHAT(-2,"微信接口调用失败"),
	OPERA_OUT(-3,"已出帐！"),
	NOT_OPERA_UP(-4,"非账单上传时间！"),
	OPERA_UP(-4,"账期数据已上传！");
	
	private int code;
	private String msg;
	
	ResultBeanCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
