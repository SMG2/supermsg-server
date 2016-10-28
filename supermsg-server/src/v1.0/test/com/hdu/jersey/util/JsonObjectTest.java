package com.hdu.jersey.util;

import com.hdu.jersey.model.SchoolInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;

import assist.main.Main;
import net.sf.json.JSONObject;

public class JsonObjectTest {
	public static void main(String[] args) {
		JSONObject object = JSONObject.fromObject(new SchoolInfo());
		System.out.println(object.toString());
	}

}
