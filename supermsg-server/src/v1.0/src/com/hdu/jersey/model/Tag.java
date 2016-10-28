package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tag")
public class Tag {

	@FormParam("tagName")
	private String tagName;
	
	@FormParam("tagid")
	private String tagid;
	
	
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagid() {
		return tagid;
	}
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
}
