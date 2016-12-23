package com.hdu.jersey.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PushHisModel {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
	
	private String pushId;
	public String getPushId() {
		return pushId;
	}
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	private String userid;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	private String tags;
	private String content;
	private boolean isPushToAll;
	private String createTime;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getIsPushToAll() {
		return isPushToAll;
	}
	public void setIsPushToAll(boolean isPushToAll) {
		this.isPushToAll = isPushToAll;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public PushHisModel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * 用于mybatis调用
	 * @param userid
	 * @param title
	 * @param tags
	 * @param content
	 * @param isPushToAll
	 * @param createTime
	 */
	public PushHisModel(String userid, String tags, boolean isPushToAll, String content, String title, String createTime) {
		this("",userid, tags, content, isPushToAll);
		this.createTime = createTime;
	}
	/**
	 * @param userid
	 * @param tags
	 * @param content
	 * @param isPushToAll 推送到全部 设置为1
	 */
	public PushHisModel(String pushId,String userid, String tags, String content, boolean isPushToAll) {
		super();
		this.pushId = pushId;
		this.userid = userid;
		this.tags = tags;
		this.content = content;
		this.isPushToAll = isPushToAll;
		this.createTime = sdf.format(new Date());
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		System.out.println(sdf.format(new Date()));
	}
	
}
