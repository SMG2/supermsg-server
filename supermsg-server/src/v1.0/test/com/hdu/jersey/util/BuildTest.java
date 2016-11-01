package com.hdu.jersey.util;

import java.util.ArrayList;

import com.hdu.jersey.model.UserDetailInfo;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;

public class BuildTest {
	public static void main(String[] args) {
		System.out.println(ResponseBuilder.build(new BaseResponseMsg(200, ""), new ArrayList<UserDetailInfo>()));;
	}

}
