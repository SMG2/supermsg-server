package com.hdu.jersey.util;

public class AuthUtil {
	
	/**
	 * ��ȡ��ǰ��ʱ�������Ϊdata��qrcode
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
	 * ��ȡ��ҳǰ����Ҫ�����Ķ˿�
	 * */
	public static String getChannel(String timestamp){
		return MD5.getResult(timestamp);
	}

}
