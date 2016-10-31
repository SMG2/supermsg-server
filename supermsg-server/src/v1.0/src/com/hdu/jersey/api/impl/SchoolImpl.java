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

import com.hdu.jersey.api.Schools;
import com.hdu.jersey.dao.impl.SchoolInfoDAOImpl;
import com.hdu.jersey.error.ErrorMsg;
import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.model.SchoolInfo;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSONObject;

@Path("/schools")
public class SchoolImpl implements Schools {
	SchoolInfoDAOImpl dao = new SchoolInfoDAOImpl();
	BaseResponseMsg msg = null;	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getAllSchools() {
		check();
		ArrayList<SchoolInfo> list_info = dao.listSchools();
		
		if(list_info.size() == 0)
			msg = new BaseResponseMsg(ResponseCode.NO_SCHOOLS_FOUND, ErrorMsg.NO_SCHOOLS_FOUND);
		else
			msg = new BaseResponseMsg(ResponseCode.OK , "");
		
		return ResponseBuilder.build(msg, list_info);
	}

	@GET
	@Path("/{school_num}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getSchoolInfoByNum(@PathParam("school_num")			String school_num) {
		check();
		SchoolInfo info = dao.getInfoByNum(school_num);
		
		if(info == null)
			msg = new BaseResponseMsg(ResponseCode.NO_SCHOOL_EXIST_WITH_GIVEN_NUM, ErrorMsg.NO_SCHOOL_EXIST_WITH_GIVEN_NUM);
		else
			msg = new BaseResponseMsg(ResponseCode.OK, "");
		
		return ResponseBuilder.build(msg, info);
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String createSchool(@BeanParam SchoolInfo info) {
		check();
		int i = dao.add(info);
		if(i != 1)
			msg = new BaseResponseMsg(ResponseCode.SCHOOL_CREATE_FAILD, ErrorMsg.SCHOOL_CREATE_FAILD);
		else
			msg = new BaseResponseMsg(ResponseCode.OK, "");
		return ResponseBuilder.build(msg, null);
	}

	/**
	 * 不建议使用
	 * 
	 * */
	@Deprecated
	@DELETE
	@Path("/{school_num}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String deleteSchoolByNum(@PathParam("school_num")		String school_num) {
		check();
		int i = dao.delete(school_num);
		if(i != 1)
			msg = new BaseResponseMsg(ResponseCode.SCHOOL_DELETE_FAILD, ErrorMsg.SCHOOL_DELETE_FAILD);
		else
			msg = new BaseResponseMsg(ResponseCode.OK, "");
		
		return ResponseBuilder.build(msg, null);
	}

	
	private void check(){
		if(this.msg != null){
			this.msg = null;
		}
	}
}
