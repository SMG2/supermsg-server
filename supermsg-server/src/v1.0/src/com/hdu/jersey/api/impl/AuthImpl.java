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
import com.hdu.jersey.dao.impl.UserLoginAuthDAOImpl;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.UserActionModel;
import com.hdu.jersey.model.UseridAndPwd;
import com.hdu.jersey.model.WebLoginAuth;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.hdu.jersey.util.BASE64;
import com.hdu.jersey.util.MD5;
import com.hdu.redis.jedis.RedisTool;
import com.sun.crypto.provider.RSACipher;

import io.goeasy.GoEasy;
import net.sf.json.JSONObject;


/**
 * 授权登录api，传入userID ，客户端调用
 * 
 * */
@Path("/auth")
public class AuthImpl implements Auth{
	GoEasy goEasy = new GoEasy(Config.APP_KEY);
	
	/**
	 * 用户登录验证,并且将userid加密返回到token里面传输到前端页面
	 * 
	 * */
	@POST
	@Path("/qrcode/{qrcode}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String authLogin(
			@BeanParam UserActionModel model,
			@PathParam("qrcode") String qrcode) {
		
		
		if(!"login".equals(model.getAction()) || "reject".equals(model.getAction()))
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.UNDEFINED_ACTION, ErrorMsg.UNDEFINED_ACTION), null);
		
		
		//解密qrcode
		byte[] a;
		try {
			a = BASE64.decryptBASE64(qrcode);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.DECRYP_ERROR, ErrorMsg.DECRYP_ERROR), null);
		}
		//获取channel
		String channel = RedisTool.get(new String(a));
		if(channel == null || "null".equals(channel))
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.NO_KEY_FOUND_IN_REDIS, ErrorMsg.NO_KEY_FOUND_IN_REDIS), null);
		
		
		JSONObject object = new JSONObject();
		object.accumulate("userid", model.getUserid());
		try {
			
			String token = BASE64.encryptBASE64(model.getUserid().getBytes());
			token  = token.substring(0, token.length()-2);
			object.accumulate("token", token);
			object.accumulate("action", model.getAction());
		} catch (Exception e) {
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.ENCRYP_ERROR, ErrorMsg.ENCRYP_ERROR), null);
		}
		
		
		new Thread(
				new Runnable() {
					
					public void run() {
						if(goEasy == null)
							goEasy = new GoEasy(Config.APP_KEY);
							goEasy.publish(channel, object.toString());
					}
				}
				).start();
		//存储（暂时不写）
		
		
		return ResponseBuilder.build(new BaseResponseMsg(200,""), null);
	}

	/**
	 * 网页获取qrcode的参数，返回给一个
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/qrcode/{timestamp}")
	public String getAuthInfoForQrcode(@PathParam("timestamp")String timestamp){
		BaseResponseMsg msg = new BaseResponseMsg(200, "");
		JSONObject object = new JSONObject();
		String qrcodeMsg = getQrcodeMsg(timestamp);
		qrcodeMsg = qrcodeMsg.substring(0, qrcodeMsg.length()-2);
//		object.accumulate("qrcode",qrcodeMsg);
		String channel  =  getChannel(timestamp);
		object.accumulate("channel", channel);
		object.accumulate("url", "http://120.27.49.173:8080/v1.0/auth/qrcode/"+qrcodeMsg);
		
		//存储qrcode信息以及管道信息到redis中
		new Thread(
				new Runnable() {
					@Override
					public void run() {
						RedisTool.set(timestamp, channel);						
					}
				}
				).start();
		return ResponseBuilder.build(msg, object);
	}
	
	/**
	 * 获取当前的时间戳，作为data的qrcode
	 * 
	 * */
	private static String getQrcodeMsg(String timestamp){
		String rel = null;
		try {
			rel = BASE64.encryptBASE64(timestamp.getBytes());
			System.out.println(rel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rel;
	}
	
	/**
	 * 获取网页前端需要监听的端口
	 * */
	private static String getChannel(String timestamp){
		return MD5.getResult(timestamp);
	}
	

	/**
	 * @return 返回是否授权
	 */
	@POST
	@Path("/account/{phone}")
	public String authLoginByAcount(@PathParam("phone") String phone,@BeanParam WebLoginAuth model){
		//获取密码
		String pwd = model.getPwd();
		UseridAndPwd queryModel = new UseridAndPwd(phone, pwd);
		UseridAndPwd re = new UserLoginAuthDAOImpl().authUser(queryModel);
		if(re != null){
			JSONObject object = new JSONObject();
			object.accumulate("userid", re.getUserid());
			return ResponseBuilder.build(new BaseResponseMsg(200, ""), object);
		}
		else 
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.UNAUTHORIZED, ErrorMsg.UNAUTHORIZED), null);
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(BASE64.encryptBASE64("helljkljlkjlk12315456o".getBytes()));
		byte[] a = BASE64.decryptBASE64("MTIzNTY0");
		System.out.println(new String(a));
	}
}
