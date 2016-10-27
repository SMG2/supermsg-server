package com.hdu.jersey.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author F-zx
 * 
 * */

@ApplicationPath("/conf")
public class JerseyResourceConf extends ResourceConfig{

	public JerseyResourceConf() {
		// TODO Auto-generated constructor stub
		//注册接口的实现类
		packages("com.hdu.jersey.api");
		packages("com.hdu.jersey.api.impl");
		
		//注册请求日志
		register(LoggingFilter.class);
	}
	
}
