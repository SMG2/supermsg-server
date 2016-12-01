package com.hdu.jersey.api.impl;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.goeasy.Config;
import com.hdu.jersey.api.Auth;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.UserActionModel;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.hdu.jersey.util.BASE64;

import io.goeasy.GoEasy;
import net.sf.json.JSONObject;


/**
 * ��Ȩ��¼api������userID ���ͻ��˵���
 * 
 * */
@Path("/auth")
public class AuthImpl implements Auth{
	GoEasy goEasy = new GoEasy(Config.APP_KEY);
	
	/**
	 * �û���¼��֤,���ҽ�userid���ܷ��ص�token���洫�䵽ǰ��ҳ��
	 * 
	 * */
	@POST
	@Path("/users/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String authLogin(
			@BeanParam UserActionModel model,
			@PathParam("userid") String userid) {
		
		if(!"login".equals(model.getAction()))
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.UNDEFINED_ACTION, ErrorMsg.UNDEFINED_ACTION), null);
		
		JSONObject object = new JSONObject();
		object.accumulate("userid", userid);
		try {
			object.accumulate("token", BASE64.encryptBASE64(userid.getBytes()));
		} catch (Exception e) {
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.ENCRYP_ERROR, ErrorMsg.ENCRYP_ERROR), null);
		}
		new Thread(
				new Runnable() {
					
					public void run() {
						if(goEasy == null)
							goEasy = new GoEasy(Config.APP_KEY);
							goEasy.publish("auth", object.toString());
					}
				}
				).start();
		//�洢����ʱ��д��
		
		
		return ResponseBuilder.build(new BaseResponseMsg(200,""), null);
	}

	/**
	 * ��ҳ��ȡqrcode�Ĳ��������ظ�һ��
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/qrcode")
	public String getAuthInfoForQrcode(){
		BaseResponseMsg msg = new BaseResponseMsg(200, "");
		JSONObject object = new JSONObject();
		object.accumulate("qrcode", getQrcodeMsg());
		object.accumulate("url", "http:120.27.49.173:8080/v1.0/auth/users/");
		return ResponseBuilder.build(msg, object);
	}
	
	/**
	 * ��ȡ��ǰ��ʱ�������Ϊdata��qrcode
	 * 
	 * */
	private static String getQrcodeMsg(){
		long s = System.currentTimeMillis();
		String rel = com.hdu.jersey.util.MD5.getResult(String.valueOf(s));
		return rel;
	}
}
