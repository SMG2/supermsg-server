package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserTag {
	
	@FormParam("tagid")
	private String tagid;
	
	@FormParam("userid")
	private String userid;
	
	
	public String getTagid() {
		return tagid;
	}
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}


}
