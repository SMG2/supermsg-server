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
	 * 通过用户的id获取用户离线时间，eg：user_userid
	 * @return 失败返回null
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
	
	/**
	 * 向topic中推送消息,返回值为已经在线订阅的人
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
		System.out.println(getOffTimeByUserId("zhuxin"));
	}
}
