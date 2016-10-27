package com.hdu.jersey.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 	������ô���
 * 	1���г��û�������tags
 * 	2���г�һ��tag�������û�
 * 	3��ɾ��ĳ���û���tag���ŵ�users��ȥ��
 * 	4��Ϊ�û�����һ��tag���ŵ�users��ȥ��
 * 
 * */
@Path("/tags")
public interface Tags {
	@GET
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllTagsByUserId(@PathParam("userid")String userid);
	
	@GET
	@Path("/{tagName}/users")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsersbyTag(@PathParam("tagName")String tag);
	
	
}