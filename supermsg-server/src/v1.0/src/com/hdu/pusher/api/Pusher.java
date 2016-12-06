package com.hdu.pusher.api;

import java.util.List;

import org.json.JSONObject;

import com.hdu.pusher.config.PusherConfig;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;
import com.tencent.xinge.XingeApp;

/**
 * 推送消息的主类，负责推送消息得到所有 设备或者到特定的tag用户
 * 
 * */
public class Pusher {
	

	private static XingeApp push = new XingeApp(PusherConfig.ACCESS_ID, PusherConfig.SECRET_KEY);
	
	private static Style style = null;
	private static Message message = null;
	
	/**
	 * 初始化
	 */
	private static void init(){
		if(style == null || message == null){
			
			style = new Style(0, 0, 1, 1, 0, 1, 1, 1);
			style.setSmallIcon("http://www.zlpix.top/resources/msg.png");
			
			message = new Message();
			//设置为通知 NOTIFICATION
			message.setType(1);
			message.setStyle(style);
		}
	}
	
	
	/**
	 * 推送信息到所有的设备
	 * 
	 * @param title 通知标题，默认为<b>通知</b>
	 * @param content 通知内容,没有默认必须填写
	 * 
	 * @return 返回值为调用接口的返回值，直接返回json object
	 * 
	 * */
	public static JSONObject pushAll(String title , String content){
		if(title == null || "".equals(title))
			title = "通知";
		
		//初始化
		if(style == null || message == null)
			init();
		
		//设置信息标题，以及内容
		message.setTitle(title);
		message.setContent(content);
		
		
		return push.pushAllDevice(0, message);
		
//		JSONObject pushAllDevice = push.pushAllDevice(0, message);
//		System.out.println(pushAllDevice.toString());
//简单默认接口，放弃调用
//XingeApp.pushAllAndroid(PusherConfig.ACCESS_ID, PusherConfig.SECRET_KEY, title, content);
		
	}
	
	/**
	 * 	推送信息到特定的tag用户
	 * 
	 * @param title 通知标题，默认为<b>通知</b>
	 * @param content 通知内容,没有默认必须填写
	 * @param tags 标签集合,默认采取OR操作
	 * @return 直接返回调用结果
	 * 
	 * @return 返回值为调用接口的返回值，直接返回json object
	 * 
	 * */
	public static JSONObject pushByTag(String title , String content, List<String> tags){
		if(title == null || "".equals(title))
			title = "通知";
		//初始化
		if(style == null || message == null)
			init();
		
		//设置信息标题，以及内容
		message.setTitle(title);
		message.setContent(content);
		return  push.pushTags(0, tags , "OR", message);
		
		
//XingeApp.pushTagAndroid(PusherConfig.ACCESS_ID,  PusherConfig.SECRET_KEY, title, content, tag);
	}

}
