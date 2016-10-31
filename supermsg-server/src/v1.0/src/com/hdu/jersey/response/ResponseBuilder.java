package com.hdu.jersey.response;

import net.sf.json.JSONObject;

/**
 * @author F-zx
 * 	����������ص�response����
 * 
 * */
public class ResponseBuilder {
	/**
	 * ���
	 * @param msg ������Ϣ��code����msg
	 * @param data ����data��Ϣ
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
