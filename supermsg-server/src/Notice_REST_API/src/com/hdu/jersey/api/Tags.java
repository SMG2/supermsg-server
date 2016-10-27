package com.hdu.jersey.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 	该类的用处：
 * 	1、列出用户的所有tags
 * 	2、列出一个tag的所有用户
 * 	3、删除某个用户的tag（放到users中去）
 * 	4、为用户创建一个tag（放到users中去）
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