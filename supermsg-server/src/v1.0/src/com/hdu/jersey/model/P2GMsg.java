package com.hdu.jersey.model;

public class P2GMsg {
	private String messageid;
	private String sender;
	private String receiver;
	private String content;
	private String createTime;
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
