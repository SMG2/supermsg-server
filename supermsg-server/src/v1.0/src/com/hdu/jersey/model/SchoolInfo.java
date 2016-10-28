package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="schoolInfo")//name="schoolinfo"
public class SchoolInfo {
	@FormParam("school_name")
	@XmlElement(name="school_name")
	private String school_name;
	
	@FormParam("school_num")
	@XmlElement(name="school_num")
	private String school_num;
	
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	
	public String getSchool_num() {
		return school_num;
	}
	public void setSchool_num(String school_num) {
		this.school_num = school_num;
	}
	@Override
	public String toString() {
		return "SchoolInfo [school_name=" + school_name + ", school_num=" + school_num + "]";
	}

	public SchoolInfo() {
		this.school_name="杭州电子科技大学";
		this.school_num="100125";
	}

}
