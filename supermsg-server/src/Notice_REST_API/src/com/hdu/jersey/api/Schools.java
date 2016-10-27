package com.hdu.jersey.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.model.SchoolInfo;

@Path("/schools")
public interface Schools {

	/**
	 * 	返回所有的学校信息（需要从网上去抓取）
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllSchools();
	
	/**
	 * 	创建一个school
	 * 
	 * */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createSchool(SchoolInfo info);
	
	@DELETE
	@Path("{school_num}")
	public String deleteSchoolByNum(
			@PathParam("school_num")		String school_num
			);
	
}



