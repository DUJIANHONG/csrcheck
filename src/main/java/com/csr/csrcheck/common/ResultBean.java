package com.csr.csrcheck.common;

import java.io.Serializable;

/**
 * 接口返回数据封装类
 */
public class ResultBean implements Serializable {

	private static final long serialVersionUID = 7711286170331714067L;
	
	private int code;
	private String msg;
	
	
	private Object data = null;
	
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

	public Object getData() {
		return data;
	}
	
	/**
	 * 放入响应码并返回自己
	 */
	public ResultBean fillCode(int code, String msg){
		this.setCode(code);
		this.setMsg(msg);
		return this;
	}
	
	/**
	 *******************************************
	 * @title:放入响应码及消息
	 * @date:Apr 11, 2019
	 * @param: @param result
	 * @param: @return  参数说明 
	 * @return:ResultBean
	 * @throws 
	 *******************************************
	 */
	public ResultBean fillCode(ResultBeanCodeEnum result){
		this.setCode(result.getCode());
		this.setMsg(result.getMsg());
		return this;
	}
	
	/**
	 * 放入自定义业务数据集合并返回自己
	 */
	public ResultBean fillData(Object data) {
		this.data = data;
		return this;
	}
	
}
