package com.hdu.jersey.model;

public class UserBaseInfo {

	private String id;
	private String phone;
	private String school_num;
	private String st_num;
	private String mail;
	private String tag;
	private String pwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSchool_num() {
		return school_num;
	}
	public void setSchool_num(String school_num) {
		this.school_num = school_num;
	}
	public String getSt_num() {
		return st_num;
	}
	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
