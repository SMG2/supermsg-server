package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 	用户基础信息类
 * 
 * */
@XmlRootElement
public class UserBaseInfo {

	@FormParam("id")
	private String id;
	@FormParam("school_num")
	private String school_num;
	@FormParam("nation")
	private String nation;
	@FormParam("st_num")
	private String st_num;
	@FormParam("pwd")
	private String pwd;
	@FormParam("sex")
	private String sex;
	@FormParam("name")
	private String name;
	
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
