package com.hdu.jersey.api.impl;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.file.FileSaver;
import com.hdu.jersey.model.FileModel;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;

import net.sf.json.JSONObject;

@Path("/file")
public class FileTransApiImpl {

	private static final String SURFIX = "http://www.zlpix.top/resources/notice/";
	
	/*---------------------------------------------------API------------------------------------------------*/
	
	/**
	 * @param model
	 * @return ·µ»Ø´æ´¢µÄµØÖ·
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/upload")
	public String updateFile(@BeanParam FileModel model){
		
		String save = FileSaver.save(model.getFileContent());
		
		String file = SURFIX+save;
		JSONObject object = new JSONObject();
		object.accumulate("url", file);
		System.out.println(file);
		
		return ResponseBuilder.build(new BaseResponseMsg(200, ""), object);
	}
}
