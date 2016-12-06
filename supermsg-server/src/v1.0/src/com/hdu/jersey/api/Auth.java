package com.hdu.jersey.api;

import com.hdu.jersey.model.UserActionModel;

/**
 * 授权登录接口
 * 
 * */
public interface Auth {
	
	/**
	 * 
	 * android端调用接口，用于二维码扫描登陆，或者其他的功能（可以拓展）
	 * */
	public String authLogin(UserActionModel model , String qrcode);

	/**
	 * 前端调用用于获取goeasy需要监听的channel，以及qrcode的内容
	 * 
	 * */
	public String getAuthInfoForQrcode(String timestamp);
}
