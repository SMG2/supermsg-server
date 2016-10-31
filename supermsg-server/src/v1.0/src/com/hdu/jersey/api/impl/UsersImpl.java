package com.hdu.jersey.api.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.validation.constraints.Null;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.dao.impl.SchoolInfoDAOImpl;
import com.hdu.jersey.dao.impl.UserBaseInfoDAOImpl;
import com.hdu.jersey.dao.impl.UserDetailInfoDAOImpl;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.UserBaseInfo;
import com.hdu.jersey.model.UserCreateModel;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.hdu.jersey.util.JsonUtil;

import assist.main.CheckStudent;

@Path("/users")
public class UsersImpl implements com.hdu.jersey.api.Users {

	UserBaseInfoDAOImpl baseInfoDaoImpl = new UserBaseInfoDAOImpl();
	UserDetailInfoDAOImpl detailDaoImpl = new UserDetailInfoDAOImpl();
	SchoolInfoDAOImpl impl = new SchoolInfoDAOImpl();
	

	BaseResponseMsg msg = null;

	/*----------如果msg不为空表示其他地方已经初始化过，所以复位----------*/
//	msg = msg!=null ? null:msg;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {
		msg = msg!=null ? null:msg;
		ArrayList<UserBaseInfo> listBaseInfo = baseInfoDaoImpl.listBaseInfo();
		if(listBaseInfo.size() == 0)
			msg = new BaseResponseMsg(ResponseCode.RESOURCE_NOT_FOUND, ErrorMsg.USERINFO_NOT＿FOUND);
		else
			msg = new BaseResponseMsg(ResponseCode.OK, "");
		return ResponseBuilder.build(msg, JsonUtil.Obj2Json(listBaseInfo));
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userid}")
	@Override
	public String getUserByUserid(@PathParam("userid")			String userid) {
		msg = msg!=null ? null:msg;
		
		if(userid == null){
			msg = new BaseResponseMsg(ResponseCode.USER_ID_NULL, ErrorMsg.USER_ID_NULL);
			return ResponseBuilder.build(msg, null);
		}
		UserBaseInfo info = baseInfoDaoImpl.showByid(userid);
		if(info == null)
			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.RESOURCE_NOT_FOUND, ErrorMsg.RESOURCE_NOT_FOUND), null);
		return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.OK, ""), JsonUtil.Obj2Json(baseInfoDaoImpl.showByid(userid)));
	}
	

	@DELETE
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)	
	@Override
	public String deleteUser(@PathParam("userid")			String userid){
		msg = msg!=null ? null:msg;
		if(userid == null){
			msg = new BaseResponseMsg(ResponseCode.USER_ID_NULL, ErrorMsg.USER_ID_NULL);
			return ResponseBuilder.build(msg, null);
		}
		
		int i = baseInfoDaoImpl.delete(userid);
		if(i == 1){
			msg = new BaseResponseMsg(ResponseCode.OK, "");
		}else{
			msg = new BaseResponseMsg(ResponseCode.USER_DELETE_ERROR, "delete faild, maybe the user is not exit or you have a wrong userid.");
		}
		return ResponseBuilder.build(msg, null);
	}
	

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String createUser(UserCreateModel model) {
		msg = msg!=null ? null:msg;
		if(model.getSchool_num() == null || "".equals(model.getSchool_num())){
			msg = new BaseResponseMsg(ResponseCode.NO_SCHOOL_ID, ErrorMsg.NO_SCHOOL_ID);
			return ResponseBuilder.build(msg, null);
		}
		if(impl.getInfoByNum(model.getSchool_num()) == null){
			msg = new BaseResponseMsg(ResponseCode.NO_SCHOOL_EXIST_WITH_GIVEN_NUM, ErrorMsg.NO_SCHOOL_EXIST_WITH_GIVEN_NUM);
			return ResponseBuilder.build(msg, null);
		}
		
		
		CheckStudent checkStudent = new CheckStudent("14108438", "Hdu1247430");
		try {
			checkStudent.login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(checkStudent.getInfo().toString());
		
		/*
{"face":"共青团员","role":"学生","major":"软件工程","nation":"汉族","grade":"2014","sex":"男","name":"朱鑫","class":"14108414","academy":"计算机学院"}
		 */
		
		return "create user by post";
	}

	@PUT
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String modify(@PathParam("userid")			String userid) {
		msg = msg!=null ? null:msg;
		
		return "modify user by id."+userid;
	}

	@GET
	@Path("/{userid}/detail")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getUserDetailInfo(@PathParam("userid")			String userid) {
		msg = msg!=null ? null:msg;
		return "get "+userid+"'s detail infomation.";
	}

	@GET
	@Path("/{userid}/tags")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getUserTags(@PathParam("userid")			String id) {
		msg = msg!=null ? null:msg;
		return "the "+id+"'s tag is tags.";
	}

	@POST
	@Path("/{userid}/tags/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String createTagforUser(
			@PathParam("userid")			String userid,
			@PathParam("tagid")				String tagid
			) {
		msg = msg!=null ? null:msg;
		return "create a tag:"+tagid+"for "+userid;
	}

	@DELETE
	@Path("/{userid}/tags/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String deleteUserTag(
			@PathParam("userid")			String userid,
			@PathParam("tagid")				String tagid
			) {
		msg = msg!=null ? null:msg;
		return "delete a tag:"+tagid+"for "+userid;
	}
	

	
	private void checkUsers(){
		
	}
	

}


//@GET
//@Path("head")
//public String testHeader(@HeaderParam("name")String name){
//	return "head  :"+name;
//}

//@GET
//@Path("head")
//@Produces(MediaType.TEXT_PLAIN)
//public String testHeader(@Context HttpHeaders headers){
//	MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
//	List<String> value =requestHeaders.get("name");
//	for (String string : value) {
//		System.out.println(string);
//	}
//	
//	return "header:"+value.get(0);
//}

//@GET
//public String get(@Context UriInfo ui) {
//    MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
//    MultivaluedMap<String, String> pathParams = ui.getPathParameters();
//	return null;
//}
