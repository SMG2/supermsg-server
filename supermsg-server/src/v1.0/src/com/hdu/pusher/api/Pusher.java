package com.hdu.pusher.api;

import java.util.List;

import org.json.JSONObject;

import com.hdu.pusher.config.PusherConfig;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;
import com.tencent.xinge.XingeApp;

/**
 * ������Ϣ�����࣬����������Ϣ�õ����� �豸���ߵ��ض���tag�û�
 * 
 * */
public class Pusher {
	

	private static XingeApp push = new XingeApp(PusherConfig.ACCESS_ID, PusherConfig.SECRET_KEY);
	
	private static Style style = null;
	private static Message message = null;
	
	/**
	 * ��ʼ��
	 */
	private static void init(){
		if(style == null || message == null){
			
			style = new Style(0, 0, 1, 1, 0, 1, 1, 1);
			style.setSmallIcon("http://www.zlpix.top/resources/msg.png");
			
			message = new Message();
			//����Ϊ֪ͨ NOTIFICATION
			message.setType(1);
			message.setStyle(style);
		}
	}
	
	
	/**
	 * ������Ϣ�����е��豸
	 * 
	 * @param title ֪ͨ���⣬Ĭ��Ϊ<b>֪ͨ</b>
	 * @param content ֪ͨ����,û��Ĭ�ϱ�����д
	 * 
	 * @return ����ֵΪ���ýӿڵķ���ֵ��ֱ�ӷ���json object
	 * 
	 * */
	public static JSONObject pushAll(String title , String content){
		if(title == null || "".equals(title))
			title = "֪ͨ";
		
		//��ʼ��
		if(style == null || message == null)
			init();
		
		//������Ϣ���⣬�Լ�����
		message.setTitle(title);
		message.setContent(content);
		
		
		return push.pushAllDevice(0, message);
		
//		JSONObject pushAllDevice = push.pushAllDevice(0, message);
//		System.out.println(pushAllDevice.toString());
//��Ĭ�Ͻӿڣ���������
//XingeApp.pushAllAndroid(PusherConfig.ACCESS_ID, PusherConfig.SECRET_KEY, title, content);
		
	}
	
	/**
	 * 	������Ϣ���ض���tag�û�
	 * 
	 * @param title ֪ͨ���⣬Ĭ��Ϊ<b>֪ͨ</b>
	 * @param content ֪ͨ����,û��Ĭ�ϱ�����д
	 * @param tags ��ǩ����,Ĭ�ϲ�ȡOR����
	 * @return ֱ�ӷ��ص��ý��
	 * 
	 * @return ����ֵΪ���ýӿڵķ���ֵ��ֱ�ӷ���json object
	 * 
	 * */
	public static JSONObject pushByTag(String title , String content, List<String> tags){
		if(title == null || "".equals(title))
			title = "֪ͨ";
		//��ʼ��
		if(style == null || message == null)
			init();
		
		//������Ϣ���⣬�Լ�����
		message.setTitle(title);
		message.setContent(content);
		return  push.pushTags(0, tags , "OR", message);
		
		
//XingeApp.pushTagAndroid(PusherConfig.ACCESS_ID,  PusherConfig.SECRET_KEY, title, content, tag);
	}

}
