package com.hdu.jersey.api;

import com.hdu.jersey.model.UserActionModel;

/**
 * ��Ȩ��¼�ӿ�
 * 
 * */
public interface Auth {
	
	public String authLogin(UserActionModel model , String qrcode);

	
	public String getAuthInfoForQrcode(String timestamp);
}
