package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 	school_num Ñ§Ð£±àºÅ </br>
 * 	st_num Ñ§ºÅ</br>
 * 	st_pwd	Ñ¡¿ÎÏµÍ³ÃÜÂë</br>
 * 	phone ºÅÂë</br>
 *  pwd µÇÂ¼ÃÜÂë
 * 
 * */
@XmlRootElement
public class UserCreateModel {
	@FormParam("school_num")
	private String school_num;
	
	@FormParam("st_num")
	private String st_num;
	
	@FormParam("st_pwd")
	private String st_pwd;
	
	@FormParam("phone")
	private String phone;
	
	@FormParam("pwd")
	private String pwd;
	
	public String getSchool_num() {
		return school_num;
	}
	public String getSt_pwd() {
		return st_pwd;
	}
	public void setSt_pwd(String st_pwd) {
		this.st_pwd = st_pwd;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
