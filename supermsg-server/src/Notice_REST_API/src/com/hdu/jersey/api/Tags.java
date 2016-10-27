package com.hdu.jersey.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.model.Tag;

/**
 * 	该类的用处：
 * 	1、列出用户的所有tags（放到users中）
 * 	2、列出一个tag的所有用户
 * 	3、删除某个用户的tag（放到users中去）
 * 	4、为用户创建一个tag（放到users中去）
 * 
 * */
@Path("/tags")
public interface Tags {
	
	/**
	 * 获得一个tag的多个用户
	 * 
	 * */
	@GET
	@Path("/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllTagsByUserId(@PathParam("tagid")String tagid);
	
	/**
	 * 创建一个tag
	 * 待完善
	 * 
	 * */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String craeteNewTag(Tag tag);
	
	
	/**
	 * 删除一个tag（最好别用，因为tag与user的复合，为user添加一个tag，或许这个tag还在使用当中）
	 * 
	 * */
	@DELETE
	@Path("/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteATagByid(@PathParam("tagid")String tagid);
	
	
	
}