package com.redis.pubsub;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

public class RedisPubListenner extends JedisPubSub{

	@Override
	public int getSubscribedChannels() {
		// TODO Auto-generated method stub
		return super.getSubscribedChannels();
	}

	@Override
	public boolean isSubscribed() {
		// TODO Auto-generated method stub
		return super.isSubscribed();
	}

	@Override
	public void onMessage(String channel, String message) {
		super.onMessage(channel, message);
		System.out.println("channel:"+channel+"  message recieve :"+message);
		
		
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		// TODO Auto-generated method stub
		super.onPMessage(pattern, channel, message);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPSubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPUnsubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onPong(String pattern) {
		// TODO Auto-generated method stub
		super.onPong(pattern);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onSubscribe(channel, subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onUnsubscribe(channel, subscribedChannels);
	}

	@Override
	public void ping() {
		// TODO Auto-generated method stub
		super.ping();
	}

	@Override
	public void proceed(Client client, String... channels) {
		// TODO Auto-generated method stub
		super.proceed(client, channels);
	}

	@Override
	public void proceedWithPatterns(Client client, String... patterns) {
		// TODO Auto-generated method stub
		super.proceedWithPatterns(client, patterns);
	}

	@Override
	public void psubscribe(String... patterns) {
		// TODO Auto-generated method stub
		super.psubscribe(patterns);
	}

	@Override
	public void punsubscribe() {
		// TODO Auto-generated method stub
		super.punsubscribe();
	}

	@Override
	public void punsubscribe(String... patterns) {
		// TODO Auto-generated method stub
		super.punsubscribe(patterns);
	}

	@Override
	public void subscribe(String... channels) {
		// TODO Auto-generated method stub
		super.subscribe(channels);
	}

	@Override
	public void unsubscribe() {
		// TODO Auto-generated method stub
		super.unsubscribe();
	}

	@Override
	public void unsubscribe(String... channels) {
		// TODO Auto-generated method stub
		super.unsubscribe(channels);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
