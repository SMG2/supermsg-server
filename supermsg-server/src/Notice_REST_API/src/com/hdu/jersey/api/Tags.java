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
 * 	������ô���
 * 	1���г��û�������tags���ŵ�users�У�
 * 	2���г�һ��tag�������û�
 * 	3��ɾ��ĳ���û���tag���ŵ�users��ȥ��
 * 	4��Ϊ�û�����һ��tag���ŵ�users��ȥ��
 * 
 * */
@Path("/tags")
public interface Tags {
	
	/**
	 * ���һ��tag�Ķ���û�
	 * 
	 * */
	@GET
	@Path("/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllTagsByUserId(@PathParam("tagid")String tagid);
	
	/**
	 * ����һ��tag
	 * ������
	 * 
	 * */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String craeteNewTag(Tag tag);
	
	
	/**
	 * ɾ��һ��tag����ñ��ã���Ϊtag��user�ĸ��ϣ�Ϊuser���һ��tag���������tag����ʹ�õ��У�
	 * 
	 * */
	@DELETE
	@Path("/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteATagByid(@PathParam("tagid")String tagid);
	
	
	
}