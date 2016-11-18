package com.redis.pool;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * �޸�localhostΪĿ��ip
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
	 * ��ʼ�����ӳ�
	 * */
	private void initPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		pool = new JedisPool(config,hostAndPort.getHost(),hostAndPort.getPort(),2000,"zx349766");//zx3497666Ϊredis���루��֤��
	}
	
	/**
	 * 	���һ��jedis
	 * */
	public synchronized  Jedis getJedis(){
		if(pool==null)
			initPool();
		Jedis jedis = pool.getResource();
		return jedis;
	}
	
	/**
	 * 	 �ͷ�һ������
	 * */
	public  void closeJedis(Jedis jedis){
		if(jedis!=null)
			jedis.close();
	}
}
