package com.hdu.jersey.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.hdu.jersey.filter.AjaxResponseFilter;
import com.hdu.jersey.filter.AuthorizationRequestFilter;

/**
 * @author F-zx
 * 
 * jersey配置文件，注册class以及packages
 * 
 * */

@ApplicationPath("/conf")
public class JerseyResourceConf extends ResourceConfig{

	public JerseyResourceConf() {
		// TODO Auto-generated constructor stub
		//注册接口的实现类
		packages("com.hdu.jersey.api.impl");
//		packages("com.hdu.web.api");
		register(AjaxResponseFilter.class);
		register(AuthorizationRequestFilter.class);
		//注册json转换区
//		register(JacksonFeature.class);
		//注册请求日志
		register(LoggingFilter.class);
	}
	
}
