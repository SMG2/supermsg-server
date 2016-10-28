package com.hdu.jersey.util;

import net.sf.json.JSONObject;

public class JsonUtil {
	
	public static String Obj2Json(Object object){
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

}
