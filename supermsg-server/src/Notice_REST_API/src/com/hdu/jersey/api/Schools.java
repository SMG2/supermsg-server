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
	 * 	�������е�ѧУ��Ϣ����Ҫ������ȥץȡ��
	 * 
	 * */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllSchools();
	
	/**
	 * 	����һ��school
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



