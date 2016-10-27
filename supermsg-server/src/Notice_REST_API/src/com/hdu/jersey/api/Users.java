package com.hdu.jersey.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public interface Users {
	
	/**
	 * 		活的所有的用户
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers();
	
	/**
	 * 	获得用户信息by用户的id
	 * @param id 用户id
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userid}")
	public String getUserByUserid(
			@PathParam("userid")			String id
			);
	
	/**
	 * 	删除用户通过用户id
	 * @param id 用户id
	 * 	
	 * */
	@DELETE
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(
			@PathParam("userid")			String id
			);
	
	
	/**
	 * 
	 * 创建用户
	 * */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createUser();
	
	
	/**XXXXXXXX
	 * 	修改用户，如果用户不存在就创建改用户
	 * */
	@PUT
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String modify(
			@PathParam("userid")			String id
			);
	
	
	/**
	 * 获得用户详细信息
	 * 
	 * */
	@GET
	@Path("/{userid}/detail")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserDetailInfo(
			@PathParam("userid")			String userid
			);
	
/******************************************************tag管理****************************************************************************/

	/**
	 * 获得某个用户的tag标签
	 * 
	 * */
	@GET
	@Path("/{userid}/tags")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserTags(
			@PathParam("userid")			String userid
			);
	
	/**
	 * 	为某个用户创建一个tag
	 * 
	 * @param userid 用户id
	 * @param tagid 标签
	 * 
	 * */
	@POST
	@Path("/{userid/tags/{tagid}}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createTagforUser(
			@PathParam("userid")			String userid,
			@PathParam("tagid")				String tagid
			);
	
	/**
	 * 	删除用户的标签
	 * 
	 * @param userid  用户id
	 * @param tagid 标签id
	 * 
	 * */
	@DELETE
	@Path("/{userid}/tags/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUserTag(
			@PathParam("userid")			String userid,
			@PathParam("tagid")				String tagid
			);
	

}

