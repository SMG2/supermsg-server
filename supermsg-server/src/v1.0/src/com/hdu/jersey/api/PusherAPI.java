package com.hdu.jersey.api;

import com.hdu.jersey.model.PusherModel;

/**
 * ��android�����ͽӿ�����
 * 
 * */
public interface PusherAPI {
	
	/**
	 * �����е��豸����֪ͨ
	 * */
	public String pushAllDev(PusherModel model);
	
	/**
	 * ���ض��ı�ǩ��������֪ͨ
	 * */
	public String pushByTags(PusherModel model);

}
