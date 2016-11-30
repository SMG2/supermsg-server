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
         * �����Headerֵ����֧��ͨ���
         */
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization,nonce,timestamp,userid,signature");
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");

        /**
         * ��ʹֻ�����м��֣�header��options�ǲ���ɾ���ģ���Ϊ�����ͨ��options��������ȡ����Ŀ������
         */
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

		
	}

}
