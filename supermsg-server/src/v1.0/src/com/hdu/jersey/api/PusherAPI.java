package com.hdu.jersey.api;

import com.hdu.jersey.model.PusherModel;

/**
 * 向android端推送接口申明
 * 
 * */
public interface PusherAPI {
	
	/**
	 * 向所有的设备推送通知
	 * */
	public String pushAllDev(PusherModel model);
	
	/**
	 * 向特定的标签用于推送通知
	 * */
	public String pushByTags(PusherModel model);

}
