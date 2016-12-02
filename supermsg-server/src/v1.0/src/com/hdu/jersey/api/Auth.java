package com.hdu.jersey.api;

import com.hdu.jersey.model.UserActionModel;

/**
 * ÊÚÈ¨µÇÂ¼½Ó¿Ú
 * 
 * */
public interface Auth {
	
	public String authLogin(UserActionModel model , String qrcode);

	
	public String getAuthInfoForQrcode(String timestamp);
}
