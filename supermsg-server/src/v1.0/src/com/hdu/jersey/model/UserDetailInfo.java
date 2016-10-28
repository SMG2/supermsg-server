package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户详细信息
 * */

@XmlRootElement
public class UserDetailInfo {
	@FormParam("id")
	private String id;
	/*班级*/
	@FormParam("class")
	private String cla;
	
	@FormParam("college")
	private String college;
	
	@FormParam("major")
	private String major;
	
	@FormParam("grade")
	private String grade;
	
	@FormParam("phone")
	private String phone;
	
	@FormParam("mail")
	private String mail;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCla() {
		return cla;
	}
	public void setCla(String cla) {
		this.cla = cla;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
