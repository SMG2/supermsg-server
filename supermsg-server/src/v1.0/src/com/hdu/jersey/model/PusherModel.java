package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author F-zx
 * 
 * 该类用于存储推送消息的载体，由客户端进行调用的时候jersey直接赋值该类
 * 
 * */

@XmlRootElement
public class PusherModel {
	@FormParam("title")
	private String title;
	@FormParam("content")
	private String content;
	/**
	 * 
	 * 标签 如果多个标签用,隔开
	 * */
	@FormParam("tags")
	private String tags;
	
	public PusherModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * 如果是发送给特定的标签人群，初始化该类
	 * */
	public PusherModel(String title,String content , String tags) {
		this.tags = tags;
		this.title = title ;
		this.content =  content ; 
		
	}
	
	/**
	 * 初始化title以及content
	 * */
	public PusherModel(String title, String content){
		this.title = title ; 
		this.content = content;
		this.tags = null;
	}
	
}
