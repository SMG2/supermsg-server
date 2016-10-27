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
	 * 		������е��û�
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers();
	
	/**
	 * 	����û���Ϣby�û���id
	 * @param id �û�id
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userid}")
	public String getUserByUserid(
			@PathParam("userid")			String id
			);
	
	/**
	 * 	ɾ���û�ͨ���û�id
	 * @param id �û�id
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
	 * �����û�
	 * */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createUser();
	
	
	/**XXXXXXXX
	 * 	�޸��û�������û������ھʹ������û�
	 * */
	@PUT
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String modify(
			@PathParam("userid")			String id
			);
	
	
	/**
	 * ����û���ϸ��Ϣ
	 * 
	 * */
	@GET
	@Path("/{userid}/detail")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserDetailInfo(
			@PathParam("userid")			String userid
			);
	
/******************************************************tag����****************************************************************************/

	/**
	 * ���ĳ���û���tag��ǩ
	 * 
	 * */
	@GET
	@Path("/{userid}/tags")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserTags(
			@PathParam("userid")			String userid
			);
	
	/**
	 * 	Ϊĳ���û�����һ��tag
	 * 
	 * @param userid �û�id
	 * @param tagid ��ǩ
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
	 * 	ɾ���û��ı�ǩ
	 * 
	 * @param userid  �û�id
	 * @param tagid ��ǩid
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

