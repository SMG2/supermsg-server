package com.redis.pubsub;



import com.redis.pool.JedisPoolTool;

import redis.clients.jedis.Jedis;

/**
 * 
 * *
 * @author F-zx
 *		主类测试
 */
public class Main {
	public static void main(String[] args) {
		Jedis jedis = JedisPoolTool.getInstance().getJedis();
		RedisPubListenner listenner = new RedisPubListenner();
		jedis.subscribe(listenner, "14108414");//14108414为群组id
		
		jedis.close();
	}

}
