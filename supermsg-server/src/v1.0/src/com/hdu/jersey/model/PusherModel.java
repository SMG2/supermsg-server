package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author F-zx
 * 
 * �������ڴ洢������Ϣ�����壬�ɿͻ��˽��е��õ�ʱ��jerseyֱ�Ӹ�ֵ����
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
	 * ��ǩ ��������ǩ��,����
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
	 * ����Ƿ��͸��ض��ı�ǩ��Ⱥ����ʼ������
	 * */
	public PusherModel(String title,String content , String tags) {
		this.tags = tags;
		this.title = title ;
		this.content =  content ; 
		
	}
	
	/**
	 * ��ʼ��title�Լ�content
	 * */
	public PusherModel(String title, String content){
		this.title = title ; 
		this.content = content;
		this.tags = null;
	}
	
}
