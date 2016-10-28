package com.hdu.jersey.api.impl;

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
import com.hdu.jersey.model.SchoolInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSONObject;

@Path("/schools")
public class SchoolImpl implements Schools {

	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getAllSchools() {
		JSONObject object = JSONObject.fromObject(new SchoolInfo());
		
		return object.toString();
	}

	@GET
	@Path("/{school_num}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getSchoolInfoByNum(@PathParam("school_num")			String school_num) {
		// TODO Auto-generated method stub
		return "get info by num:"+school_num;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public String createSchool(@BeanParam SchoolInfo info) {
		
		System.out.println("resource :"+info);
		// TODO Auto-generated method stub
		return "create school info "+info.getSchool_name();
	}

	@DELETE
	@Path("/{school_num}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String deleteSchoolByNum(@PathParam("school_num")		String school_num) {
		// TODO Auto-generated method stub
		return "delete school by num:"+school_num;
	}

}
