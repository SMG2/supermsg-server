package com.hdu.jersey.api;

import com.hdu.jersey.model.UserActionModel;

/**
 * ��Ȩ��¼�ӿ�
 * 
 * */
public interface Auth {
	
	/**
	 * 
	 * android�˵��ýӿڣ����ڶ�ά��ɨ���½�����������Ĺ��ܣ�������չ��
	 * */
	public String authLogin(UserActionModel model , String qrcode);

	/**
	 * ǰ�˵������ڻ�ȡgoeasy��Ҫ������channel���Լ�qrcode������
	 * 
	 * */
	public String getAuthInfoForQrcode(String timestamp);
}
