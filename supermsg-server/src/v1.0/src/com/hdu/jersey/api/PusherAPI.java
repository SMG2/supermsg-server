package com.hdu.jersey.api;

import javax.ws.rs.core.HttpHeaders;

import com.hdu.jersey.model.PusherModel;

/**
 * 向android端推送接口申明
 * 
 * */
public interface PusherAPI {
	
	/**
	 * 向所有的设备推送通知
	 * */
	String pushAllDev(HttpHeaders hh, PusherModel model);
	
	/**
	 * 向特定的标签用于推送通知
	 * */
	String pushByTags(HttpHeaders hh, PusherModel model);


}
