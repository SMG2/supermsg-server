package com.hdu.jersey.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.dao.impl.UserBaseInfoDAOImpl;
import com.hdu.jersey.dao.impl.UserDetailInfoDAOImpl;
import com.hdu.jersey.model.UserBaseInfo;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;

import net.sf.json.JSONObject;

/**
 * 群组接口：
 *  1.获取群组中的所有用户
 *  2.获取用户所在群组
 * 
 * */
@Path("/groups")
public class Groups {

	UserDetailInfoDAOImpl util = new UserDetailInfoDAOImpl();
	
	private BaseResponseMsg msg = null;
	private UserBaseInfoDAOImpl baseInfoDaoImpl = new UserBaseInfoDAOImpl();
	
	
	/**
	 * 通过群组id获取群组中所有用户id
	 * @param groupid 群组id<b>从url中获取</b>
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{groupid}/users")
	public String getUsersByGroupid(
			@PathParam("groupid") String groupid){
		check();
		List<UserBaseInfo> user_list = new ArrayList<>();
		List<String> userid_list = util.getUseridsByclass(groupid);
		if(userid_list.size() == 0)
			msg = new BaseResponseMsg(460, "empty group.");
		else {
			for (String user : userid_list) {
				System.out.println("select userid:"+user);
				UserBaseInfo baseInfo = baseInfoDaoImpl.showByid(user);
				user_list.add(baseInfo);
			}
			msg = new BaseResponseMsg(200, "");
		}
		
		JSONObject object = new JSONObject();
		object.accumulate("uerid_list", userid_list);
		object.accumulate("userData", user_list);
		return ResponseBuilder.build(msg, object);
		
	}
	
	private void check(){
		if(this.msg != null){
			this.msg = null;
		}
	}
}
