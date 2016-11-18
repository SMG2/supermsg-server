package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="message")
public class GroupMessages {
	
	@FormParam("groupid")
	private String groupid;
	@FormParam("userid")
	private String userid;
//	@FormParam("createTime")
//	private String createTime;
	@FormParam("content")
	private String content;
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
//	public String getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(String createTime) {
//		this.createTime = createTime;
//	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
