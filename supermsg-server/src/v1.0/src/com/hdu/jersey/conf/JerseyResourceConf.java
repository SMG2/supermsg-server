package com.hdu.jersey.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.hdu.jersey.filter.AjaxResponseFilter;
import com.hdu.jersey.filter.AuthorizationRequestFilter;

/**
 * @author F-zx
 * 
 * jersey�����ļ���ע��class�Լ�packages
 * 
 * */

@ApplicationPath("/conf")
public class JerseyResourceConf extends ResourceConfig{

	public JerseyResourceConf() {
		// TODO Auto-generated constructor stub
		//ע��ӿڵ�ʵ����
		packages("com.hdu.jersey.api.impl");
//		packages("com.hdu.web.api");
		register(AjaxResponseFilter.class);
		register(AuthorizationRequestFilter.class);
		//ע��jsonת����
//		register(JacksonFeature.class);
		//ע��������־
		register(LoggingFilter.class);
	}
	
}
