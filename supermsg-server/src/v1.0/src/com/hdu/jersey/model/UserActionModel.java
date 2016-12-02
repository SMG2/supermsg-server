package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import redis.clients.jedis.Jedis;

/**
 * 用户的动作，封装行为
 * 
 * */
@XmlRootElement
public class UserActionModel {
	@FormParam("action")
	private String action;
	
	@FormParam("userid")
	private String userid;
	

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}




	public static void main(String[] args) {
		Jedis jedis = new Jedis("120.27.49.173",6380);
		jedis.auth("zx349766");
		System.out.println(jedis.get("foo"));
		jedis.close();
	}
}
