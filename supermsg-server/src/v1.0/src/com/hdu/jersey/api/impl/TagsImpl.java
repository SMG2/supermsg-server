package com.hdu.jersey.api.impl;

import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.api.Tags;
import com.hdu.jersey.dao.impl.TagDAOImpl;
import com.hdu.jersey.dao.impl.UserTagDAOImpl;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.Tag;
import com.hdu.jersey.model.UserTag;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;


/**
 * 标签接口，标签的CRUD
 * */
@Path("/tags")
public class TagsImpl implements Tags{

	TagDAOImpl tagdao = new TagDAOImpl();
	UserTagDAOImpl userTagDao = new UserTagDAOImpl();
	
	BaseResponseMsg msg = null;
	
	/**
	 * 获取所有的标签信息
	 * url：/v1.0/tags
	 * */
	@GET
	@Path("/{tagid}/users")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getAllTagsByTagId(@PathParam("tagid")			String tagid) {
		checkMsg();
		ArrayList<UserTag> list = null;
		if(tagid==null||"".equals(tagid))
			msg = new BaseResponseMsg(ResponseCode.TAG_ID_NULL, ErrorMsg.TAG_ID_NULL);
		else{
			list = userTagDao.getUsersByTagId(tagid);
			if(list.size() == 0)
				msg = new BaseResponseMsg(ResponseCode.NO_USERS_FOR_TAG, ErrorMsg.NO_USERS_FOR_TAG);
			else
				msg = new BaseResponseMsg(200, "");
		}
		
		return ResponseBuilder.build(msg, list);
	}

	
	/**
	 * 创建一个标签<br/>
	 * url：/v1.0/tags/
	 * method:post
	 * 
	 * */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String craeteNewTag(@BeanParam Tag tag) {
		checkMsg();
		if(tagdao.createTag(tag) != 1)
			msg = new BaseResponseMsg(ResponseCode.CREATE_FAIL_FOR_TAG_EXIST, ErrorMsg.CREATE_FAIL_FOR_TAG_EXIST);
		else
			msg = new BaseResponseMsg(200, "");
 		return ResponseBuilder.build(msg, null);
	}
	
	/*
	 * 删除一个标签<br/>
	 * url：v1.0/tags/<br/>
	 * method:delete
	 * **/
	@Deprecated
	@DELETE
	@Path("/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String deleteATagByid(@PathParam("tagid")			String tagid) {
		checkMsg();
		// TODO Auto-generated method stub
		return "delete a tag by id:"+tagid;
	}

	
	private void checkMsg(){
		msg = msg!=null ? null:msg;
	}
}
