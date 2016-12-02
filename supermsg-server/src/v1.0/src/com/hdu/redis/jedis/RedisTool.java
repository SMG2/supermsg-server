package com.hdu.redis.jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hdu.jersey.model.GroupMessages;
import com.hdu.redis.pool.JedisPoolTool;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

public class RedisTool {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
	private static JedisPoolTool pool = null;
	private final static String OFF_LINE_TIME_TAG = "offLineTime";
	
	/**
	 * ͨ���û���id��ȡ�û�����ʱ�䣬eg��user_userid
	 * @return ʧ�ܷ���null
	 * */
	public static String getOffTimeByUserId(String userid){
		if(pool == null)
			pool = JedisPoolTool.getInstance();
		Jedis jedis = pool.getJedis();
		
		String user = "user_"+userid;
		List<String> time = jedis.hmget(user, OFF_LINE_TIME_TAG);
		if(time == null){
			pool.closeJedis(jedis);
			return null;
		}
		else{
			pool.closeJedis(jedis);
			return time.get(0);
		}
	}
	

	private static int count = 0;
	/**
	 * �洢qrcode��¼��Ϣ��redis����ʱ������Լ�md5��channel��Ϣ�洢��redis���ݿ�
	 * 
	 * */
	public static String set(String timestamp,String channel){
		if(pool == null)
			pool = JedisPoolTool.getInstance();
		Jedis jedis = pool.getJedis();
		String rel = jedis.set("qrcode_"+timestamp, channel);
		if(!"OK".equalsIgnoreCase(rel) && count++ < 3)
			set(timestamp, channel);
		pool.closeJedis(jedis);
		return rel;
	}
	
	/**
	 * ��ȡ��ʱ�������Ϣ,������Ϣǰ�����qrcode�������
	 * 
	 * @author F-zx
	 * @return ����md5������Ϣ������ϢΪchannel�����channel������Ϣ����¼action
	 * 
	 * */
	public static String get(String timestamp){
		if(pool == null)
			pool = JedisPoolTool.getInstance();
		Jedis jedis = pool.getJedis();
		String rel = jedis.get("qrcode_"+timestamp);
		pool.closeJedis(jedis);
		return rel;
	}
	
	/**
	 * ��topic��������Ϣ,����ֵΪ�Ѿ����߶��ĵ���
	 * 
	 * */
	public static long pushMessages(GroupMessages messages){
		if(pool == null)
			pool = JedisPoolTool.getInstance();
		Jedis jedis = pool.getJedis();
		
		JSONObject object = JSONObject.fromObject(messages);
		object.accumulate("craeteTime", format.format(new Date()));
		long count = jedis.publish(messages.getGroupid(), object.toString());
		pool.closeJedis(jedis);
		return count;
	}

	public static void main(String[] args) {
//		System.out.println(getOffTimeByUserId("zhuxin"));
		
		
//		System.out.println(set("123", "456"));
		System.out.println(get("123"));
	}
}
