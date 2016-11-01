package com.hdu.jersey.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	static JSONObject jsonObject = null;
	static JSONArray jsonArray = null;
	public static String testObj2Json(Object object){
		if(object instanceof JSONArray)
			jsonArray = JSONArray.fromObject(object);
		else
			jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}
	
//	public static String obj

}
