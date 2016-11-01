package com.hdu.jersey.util;

import com.hdu.jersey.model.SchoolInfo;

import net.sf.json.JSONObject;

public class JsonObjectTest {
	public static void main(String[] args) {
		JSONObject object = JSONObject.fromObject(new SchoolInfo());
		System.out.println(object.toString());
	}

}
