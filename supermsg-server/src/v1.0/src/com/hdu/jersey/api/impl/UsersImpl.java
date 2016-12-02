package com.hdu.jersey.api.impl;

import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.goeasy.Config;
import com.hdu.jersey.dao.impl.GroupMessageDAOImpl;
import com.hdu.jersey.dao.impl.OffLineMsgDAOImpl;
import com.hdu.jersey.dao.impl.SchoolInfoDAOImpl;
import com.hdu.jersey.dao.impl.UserBaseInfoDAOImpl;
import com.hdu.jersey.dao.impl.UserDetailInfoDAOImpl;
import com.hdu.jersey.dao.impl.UserTagDAOImpl;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.GroupLogResponse;
import com.hdu.jersey.model.GroupMessages;
import com.hdu.jersey.model.P2PMsg;
import com.hdu.jersey.model.Tag;
import com.hdu.jersey.model.UserActionModel;
import com.hdu.jersey.model.UserBaseInfo;
import com.hdu.jersey.model.UserCreateModel;
import com.hdu.jersey.model.UserDetailInfo;
import com.hdu.jersey.model.UserTag;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.hdu.jersey.util.BASE64;
import com.hdu.jersey.util.GetStudentInfo;
import com.hdu.openfire.regist.UserRegister;
import com.hdu.redis.jedis.RedisTool;

import io.goeasy.GoEasy;
import net.sf.json.JSONObject;

@Path("/users")
public class UsersImpl implements com.hdu.jersey.api.Users {

	UserBaseInfoDAOImpl baseInfoDaoImpl = new UserBaseInfoDAOImpl();
	UserDetailInfoDAOImpl detailDaoImpl = new UserDetailInfoDAOImpl();
	OffLineMsgDAOImpl offLineMsgDAOImpl = new OffLineMsgDAOImpl();
	GroupMessageDAOImpl  groupMessageDAOImpl = new GroupMessageDAOImpl();
	SchoolInfoDAOImpl impl = new SchoolInfoDAOImpl();
	UserTagDAOImpl userTagDAOImpl = new UserTagDAOImpl();
	GoEasy goEasy = new GoEasy(Config.APP_KEY);
	

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
		return ResponseBuilder.build(msg, listBaseInfo);
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
		return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.OK, ""), baseInfoDaoImpl.showByid(userid));
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
	public String createUser(@BeanParam UserCreateModel model) {
		msg = msg!=null ? null:msg;
		if(model.getSchool_num() == null || "".equals(model.getSchool_num())){
			msg = new BaseResponseMsg(ResponseCode.NO_SCHOOL_ID, ErrorMsg.NO_SCHOOL_ID);
			return ResponseBuilder.build(msg, null);
		}
		if(impl.getInfoByNum(model.getSchool_num()) == null){
			msg = new BaseResponseMsg(ResponseCode.NO_SCHOOL_EXIST_WITH_GIVEN_NUM, ErrorMsg.NO_SCHOOL_EXIST_WITH_GIVEN_NUM);
			return ResponseBuilder.build(msg, null);
		}

		GetStudentInfo st_util = GetStudentInfo.getInstance(
				model.getSt_num(), model.getSt_pwd(), model.getPwd(), model.getPhone(), model.getSchool_num()
				);
		st_util.spideFromWebAndLoad();
		if(!st_util.isSuccess())
			msg = new BaseResponseMsg(ResponseCode.WRONG_PWD_OR_STNUM, ErrorMsg.WRONG_PWD_OR_STNUM);
		else{
			//在openfire中注册
			UserRegister register = new UserRegister();
			if(!register.regist(model.getSchool_num()+model.getSt_num(), model.getPwd())){
				msg = new BaseResponseMsg(ResponseCode.FAIL_TO_REGIST_IN_OPENGIRE, ErrorMsg.FAIL_TO_REGIST_IN_OPENGIRE);
				return ResponseBuilder.build(msg, null);
			}
			int i = baseInfoDaoImpl.add(st_util.getBaseInfo());
			int j = detailDaoImpl.add(st_util.getDetailInfo());
			if(i != 1 || j != 1)
				msg = new BaseResponseMsg(ResponseCode.USER_EXIST, ErrorMsg.USER_EXIST);
			else{
				msg = new BaseResponseMsg(200, "");
			}
		}
		return ResponseBuilder.build(msg, null);
	}

	@Deprecated
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
		if("".equals(userid)|| userid == null)
			msg = new BaseResponseMsg(ResponseCode.USER_ID_NULL, ErrorMsg.USER_ID_NULL);
		UserDetailInfo info = detailDaoImpl.getDetail(userid);
		if(info == null)
			msg = new BaseResponseMsg(ResponseCode.USER_NOT_EXIST, ErrorMsg.USER_NOT_EXIST);
		else
			msg = new BaseResponseMsg(200, "");
		
		return ResponseBuilder.build(msg, info);
	}

	@GET
	@Path("/{userid}/tags")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getUserTags(@PathParam("userid")			String userid) {
		msg = msg!=null ? null:msg;
		if("".equals(userid)|| userid == null)
			msg = new BaseResponseMsg(ResponseCode.USER_ID_NULL, ErrorMsg.USER_ID_NULL);
		ArrayList<Tag> list_tags = userTagDAOImpl.getTagsByUserid(userid);
		if(list_tags.size()<1)
			msg = new BaseResponseMsg(ResponseCode.USER_TAG_NOT_SET, ErrorMsg.USER_TAG_NOT_SET);
		else
			msg = new BaseResponseMsg(200, "");
		return ResponseBuilder.build(msg, list_tags);
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
		UserTag userTag = new UserTag();
		userTag.setTagid(tagid);
		userTag.setUserid(userid);
		if(userTagDAOImpl.addTagForUser(userTag))
			msg = new BaseResponseMsg(200, "");
		else
			msg = new BaseResponseMsg(ResponseCode.FAIL_TOADD_TAG_FOR_USER, "fail to add, user not exist or tagid not exist.");
		
		return ResponseBuilder.build(msg, null);
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
		UserTag userTag = new UserTag();
		userTag.setTagid(tagid);
		userTag.setUserid(userid);
		
		if(userTagDAOImpl.delete(userTag) == 1)
			msg = new BaseResponseMsg(200, "");
		else
			msg = new BaseResponseMsg(ResponseCode.FAIL_DELETE_TAG_FOR_USER, "delete failed , check the userid and tagid .there is no tagid for this user.");
			return ResponseBuilder.build(msg, null);
	}

	@Override
	@GET
	@Path("/{userid}/offlineMsgs")
	public String getOffLineMsg(
			@PathParam("userid")			String userid) {
		ArrayList<P2PMsg> offLineMsg_p2p = null;
		JSONObject object = null;
		
		String offLine = RedisTool.getOffTimeByUserId(userid);
		if(offLine == null)
			msg = new BaseResponseMsg(ResponseCode.USER_IS_NOT_OFFLINE, "redis 中不存在该用户离线数据.");
		else{
			offLineMsg_p2p = offLineMsgDAOImpl.getOffLineMsg(userid, offLine);
			object = new JSONObject();
			object.accumulate("p2pmsg", offLineMsg_p2p);
			msg = new BaseResponseMsg(200, "");
		}
		
		return ResponseBuilder.build(msg, object);
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/{userid}/messages/push")
	public String pushMessages(
			@BeanParam GroupMessages messages){
		long count = 0;
		checkMsg();
		
		if(messages.getGroupid() == null || "".equals(messages.getGroupid()))
			msg = new BaseResponseMsg(451, "messages id null.");
		else{
			new Thread(
					new Runnable() {
						
						public void run() {
							if(goEasy == null)
								goEasy = new GoEasy(Config.APP_KEY);
							goEasy.publish(messages.getGroupid(), messages.getContent());
						}
					}
					).start();
			
			//新起一个线程去存储message信息
			new Thread(
					new Runnable() {
						
						public void run() {
							int i = groupMessageDAOImpl.add(messages);
							System.out.println("messages 插入："+i);
							
						}
					}
					).start();
			count = RedisTool.pushMessages(messages);
			String str = "群组中在线的"+count+"人已经收到。";
			msg = new BaseResponseMsg(200, str);
		}
		return ResponseBuilder.build(msg, null);
		
	}
	
	@GET
	@Path("/{userid}/groupmessages/{groupid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOfflineGroupMsg(
			@PathParam("userid") String userid,
			@PathParam("groupid") String groupid){
		checkMsg();
		ArrayList<GroupLogResponse> logs = groupMessageDAOImpl.getById(userid, groupid);
		JSONObject object = new JSONObject();
		object.accumulate("groupChatLogs", logs);
		msg = new BaseResponseMsg(200, "");
		return ResponseBuilder.build(msg, object);
	}
	
	
	private void checkMsg(){
		msg = msg!=null ? null:msg;
	}

	
	
	/*-------------------------------------------------------groups-------------------------------------------------------------------------*/
	
	@GET
	@Path("/{userid}/group")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserGroup(
			@PathParam("userid") String userid){
		checkMsg();

		JSONObject object = new JSONObject();
		String group = detailDaoImpl.getUserGroupByUserid(userid);
		if("".equals(group)){
			msg = new BaseResponseMsg(ResponseCode.USER_NOT_EXIST, ErrorMsg.USER_NOT_EXIST);
			object = null;
		}
		else{

			msg = new BaseResponseMsg(200, "");
			object.accumulate("group", group);
		}
		
		return ResponseBuilder.build(msg, object);
	}
	
	/*------------------------------------------------------auth----------------------------------------------------------------------*/
	
	/**
	 * 用户登录验证,并且将userid加密返回到token里面传输到前端页面
	 * 
	 * */
//	@POST
//	@Path("/auth/{qrcode}")
//	@Produces(MediaType.TEXT_PLAIN)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public String authLogin(
//			@BeanParam UserActionModel model,
//			@PathParam("qrcode") String qrcode) {
//		
//		if(!"login".equals(model.getAction()))
//			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.UNDEFINED_ACTION, ErrorMsg.UNDEFINED_ACTION), null);
//		
//		
//		//解密qrcode
//		byte[] a;
//		try {
//			a = BASE64.decryptBASE64(qrcode);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.DECRYP_ERROR, ErrorMsg.DECRYP_ERROR), null);
//		}
//		//获取channel
//		String channel = RedisTool.get(new String(a));
//		if(channel == null || "null".equals(channel))
//			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.NO_KEY_FOUND_IN_REDIS, ErrorMsg.NO_KEY_FOUND_IN_REDIS), null);
//		
//		
//		JSONObject object = new JSONObject();
//		object.accumulate("userid", model.getUserid());
//		try {
//			object.accumulate("token", BASE64.encryptBASE64(model.getUserid().getBytes()));
//			object.accumulate("action", model.getAction());
//		} catch (Exception e) {
//			return ResponseBuilder.build(new BaseResponseMsg(ResponseCode.ENCRYP_ERROR, ErrorMsg.ENCRYP_ERROR), null);
//		}
//		
//		
//		new Thread(
//				new Runnable() {
//					
//					public void run() {
//						if(goEasy == null)
//							goEasy = new GoEasy(Config.APP_KEY);
//							goEasy.publish(channel, object.toString());
//					}
//				}
//				).start();
//		//存储（暂时不写）
//		
//		
//		return ResponseBuilder.build(new BaseResponseMsg(200,""), null);
//	}
}