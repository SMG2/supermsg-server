package com.hdu.jersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class AjaxResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		
		System.out.println("-------------------------ajax filter-----------------------------------");
		 /**
         * 允许的Header值，不支持通配符
         */
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization,nonce,timestamp,userid,signature");
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");

        /**
         * 即使只用其中几种，header和options是不能删除的，因为浏览器通过options请求来获取服务的跨域策略
         */
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

		
	}

}
