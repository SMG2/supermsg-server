package com.hdu.jersey.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.hdu.jersey.api.PusherAPI;
import com.hdu.jersey.dao.impl.PushHisDAOImpl;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.PushHisModel;
import com.hdu.jersey.model.PusherModel;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.hdu.pusher.api.Pusher;

/**
 * @author F-zx
 * 
 * ������Ϣ�ӿ�ʵ��
 *
 * 
 * */
@Path("/push")
public class PusherAPIImpl implements PusherAPI {
	private PushHisDAOImpl daoImpl = new PushHisDAOImpl();

	/**
	 * �����е��û�������Ϣ
	 * 
	 * */
	@POST
	@Path("/all")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String pushAllDev( 
			@Context HttpHeaders hh,
			@BeanParam PusherModel model) {
		String msg = "";
		
		if(model.getTitle() == null || "".equals(model.getTitle()))
			msg = "title is empty , default '֪ͨ'";
		
		
		JSONObject object = Pusher.pushAll(model.getTitle(), model.getContent());
		
		String userid = hh.getHeaderString("userid");
		System.out.println("------------------------"+userid);
		//insert into database
				PushHisModel pushHisModel =  new PushHisModel(object.getJSONObject("result").getString("push_id")
						,userid, "", model.getContent(), true);
				daoImpl.add(pushHisModel);
		return ResponseBuilder.build(new BaseResponseMsg(200, msg), object.toString());
	}

	/**
	 * ���ض���tags�û�������Ϣ��tags��������еģ�
	 * 
	 * */
	@POST
	@Path("/tags")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String pushByTags( 
			@Context HttpHeaders hh,
			@BeanParam PusherModel model) {
		
		BaseResponseMsg msg = null;
		JSONObject object = null;
		//�û���ǩû�и������޷�����
		if("".equals(model.getTags()) || model.getTags() == null)
			msg = new BaseResponseMsg(ResponseCode.PUSH_TAGS_BE_NULL , ErrorMsg.EMPTY_TAGS_OR_TAGS_NOT_SET_WHEN_PUSHING);
		else{
			//���tagsȻ���з�Ϊһ������
			String []  tags = model.getTags().split(",");
			List<String> tag_list = new ArrayList<>();
			//������װ�ڵ�list�У�Ȼ�󴫵ݸ�pusher���е���
			for (String tag : tags) {
				tag_list.add(tag);
			}

			String userid = hh.getHeaderString("userid");
			System.out.println("---------push to user by tags---------------"+userid);
			//insert into database
			PushHisModel pushHisModel =  new PushHisModel(object.getJSONObject("result").getString("push_id")
					,userid, model.getTags(), model.getContent(), false);
			try {
				daoImpl.add(pushHisModel);
			} catch (Exception e) {
				System.err.println("error in store push history logs.");
			}
			
			object = Pusher.pushByTag(model.getTitle(), model.getContent(), tag_list);
			msg = new BaseResponseMsg(200, "");
		}
		return ResponseBuilder.build(msg, object.toString());
	}

	@GET
	@Path("/his")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllPushHis(){
		JSONObject object = new JSONObject();
		List<PushHisModel> list = daoImpl.selectAll();
		object.accumulate("pushLog", list);
		return ResponseBuilder.build(new BaseResponseMsg(200, ""), object.toString());
	}


}
