package com.hdu.jersey.api;

import javax.ws.rs.core.HttpHeaders;

import com.hdu.jersey.model.PusherModel;

/**
 * ��android�����ͽӿ�����
 * 
 * */
public interface PusherAPI {
	
	/**
	 * �����е��豸����֪ͨ
	 * */
	String pushAllDev(HttpHeaders hh, PusherModel model);
	
	/**
	 * ���ض��ı�ǩ��������֪ͨ
	 * */
	String pushByTags(HttpHeaders hh, PusherModel model);


}
