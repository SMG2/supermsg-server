package com.hdu.redis.pool;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhuxin
 *
 */
public class JedisPoolTool {
	private static HostAndPort hostAndPort = new HostAndPort("120.27.49.173", 6380);
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
	 */
	private void initPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		pool = new JedisPool(config,hostAndPort.getHost(),hostAndPort.getPort(),2000,"zx349766");
	}
	

	/**
	 * @return 返回一个jedis对象
	 */
	public synchronized  Jedis getJedis(){
		if(pool==null)
			initPool();
		Jedis jedis = pool.getResource();
		return jedis;
	}
	

	/**
	 * 关闭jedis
	 * 
	 * @param jedis
	 */
	public  void closeJedis(Jedis jedis){
		if(jedis!=null)
			jedis.close();
	}
}
