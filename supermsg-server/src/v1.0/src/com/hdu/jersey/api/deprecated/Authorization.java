package com.hdu.jersey.api.deprecated;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.hdu.jersey.util.AuthUtil;
import com.hdu.redis.jedis.RedisTool;

import net.sf.json.JSONObject;

@Path("/auth")
public class Authorization {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/qrcode/{timestamp}")
	public String test(@PathParam("timestamp") String timestamp){
		
		BaseResponseMsg msg = new BaseResponseMsg(200, "");
		JSONObject object = new JSONObject();
		String qrcodeMsg = AuthUtil.getQrcodeMsg(timestamp);
		System.out.println(qrcodeMsg);
		object.accumulate("qrcode",qrcodeMsg);
		String channel  =  AuthUtil.getChannel(timestamp);
		object.accumulate("channel", channel);
		object.accumulate("url", "http://120.27.49.173:8080/v1.0/users/auth/"+qrcodeMsg);
//		RedisTool.set(timestamp, channel);
		
		//存储qrcode信息以及管道信息到redis中
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				RedisTool.set(timestamp, channel);
				
			}
		}).start();
		return ResponseBuilder.build(msg, object);
		
	}
	

}
