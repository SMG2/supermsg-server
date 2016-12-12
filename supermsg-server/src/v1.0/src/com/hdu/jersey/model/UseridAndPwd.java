package com.hdu.jersey.model;

public class UseridAndPwd {
	private String userid;
	private String phoneNum;
	private String password;
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UseridAndPwd(String userid, String phoneNum, String password) {
		super();
		this.userid = userid;
		this.phoneNum = phoneNum;
		this.password = password;
	}
	public UseridAndPwd(String phoneNum, String password) {
		super();
		this.phoneNum = phoneNum;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UseridAndPwd [userid=" + userid + ", phoneNum=" + phoneNum + ", password=" + password + "]";
	}
	

	
}
