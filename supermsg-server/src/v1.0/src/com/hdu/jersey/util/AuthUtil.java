package com.hdu.jersey.util;

public class AuthUtil {
	
	/**
	 * 获取当前的时间戳，作为data的qrcode
	 * 
	 * */
	public static String getQrcodeMsg(String timestamp){
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
	public static String getChannel(String timestamp){
		return MD5.getResult(timestamp);
	}

}
