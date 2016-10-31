package com.hdu.jersey.response;

import net.sf.json.JSONObject;

/**
 * @author F-zx
 * 	用于组件返回的response内容
 * 
 * */
public class ResponseBuilder {
	/**
	 * 组件
	 * @param msg 基础信息，code加上msg
	 * @param data 返回data信息
	 * 
	 * */
	public static String build(BaseResponseMsg msg,Object data){
		JSONObject object = new JSONObject();
		object.accumulate("code", msg.getCode());
		object.accumulate("msg", msg.getMsg());
		if(data != null)
			object.accumulate("data", data);
		return object.toString();
	}
}
