package com.hdu.jersey.response;

public class BaseResponseMsg {
	private int code;
	
	private String msg;

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
	
	public BaseResponseMsg(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	

}
