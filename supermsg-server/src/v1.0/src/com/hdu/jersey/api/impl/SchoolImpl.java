package com.hdu.jersey.api.impl;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.api.Schools;
import com.hdu.jersey.model.SchoolInfo;

@Path("/schools")
public class SchoolImpl implements Schools {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getAllSchools() {
		// TODO Auto-generated method stub
		return "all schools infomation.";
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
	@Override
	public String createSchool(SchoolInfo info) {
		// TODO Auto-generated method stub
		return "create school info ";
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
