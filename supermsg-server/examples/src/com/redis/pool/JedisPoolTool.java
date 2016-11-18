package com.redis.pool;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 修改localhost为目标ip
 * */
public class JedisPoolTool {
	private static HostAndPort hostAndPort = new HostAndPort("localhost", 6380);//localhost == > 120.27.49.173
	private static JedisPool pool = null;
	
	private static JedisPoolTool myPool = new JedisPoolTool();
	
	private JedisPoolTool(){
		initPool();
	}
	
	public static JedisPoolTool getInstance(){
		return myPool;
	}
	
	/**
	 * 初始化连接池
	 * */
	private void initPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		pool = new JedisPool(config,hostAndPort.getHost(),hostAndPort.getPort(),2000,"zx349766");//zx3497666为redis密码（验证）
	}
	
	/**
	 * 	获得一个jedis
	 * */
	public synchronized  Jedis getJedis(){
		if(pool==null)
			initPool();
		Jedis jedis = pool.getResource();
		return jedis;
	}
	
	/**
	 * 	 释放一个连接
	 * */
	public  void closeJedis(Jedis jedis){
		if(jedis!=null)
			jedis.close();
	}
}
