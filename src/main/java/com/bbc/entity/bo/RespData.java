package com.bbc.entity.bo;

public class RespData {

	private Integer code=200;
	private String msg="success";

	private Object obj;

	public RespData(){}

	public RespData(Integer code, String msg){
		this.code=code;
		this.msg=msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
