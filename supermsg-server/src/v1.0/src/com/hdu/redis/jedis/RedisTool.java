package com.hdu.redis.jedis;

import java.util.List;

import com.hdu.redis.pool.JedisPoolTool;

import redis.clients.jedis.Jedis;

public class RedisTool {
	
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

	public static void main(String[] args) {
		System.out.println(getOffTimeByUserId("zhuxin"));
	}
}
