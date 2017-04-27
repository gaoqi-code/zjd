package com.bbc.entity.bo;

import java.util.List;

public class Data {
	
	private Integer code=200;
	private String msg="success";
	
	private List<?> data;
	
	public Data(){}
	
	public Data(Integer code,String msg){
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
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
}
