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
		//ע��ӿڵ�ʵ����
		packages("com.hdu.jersey.api");
		packages("com.hdu.jersey.api.impl");
		
		//ע��������־
		register(LoggingFilter.class);
	}
	
}
