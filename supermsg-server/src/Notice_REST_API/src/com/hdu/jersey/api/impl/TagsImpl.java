package com.hdu.jersey.api.impl;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hdu.jersey.api.Tags;
import com.hdu.jersey.model.Tag;

@Path("/tags")
public class TagsImpl implements Tags{

	@GET
	@Path("/{tagid}/users")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getAllTagsByUserId(@PathParam("tagid")			String tagid) {
		// TODO Auto-generated method stub
		return "those users have be chown a tagid:"+tagid;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String craeteNewTag(Tag tag) {
		// TODO Auto-generated method stub
		return "create a new tag.";
	}

	@DELETE
	@Path("/{tagid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String deleteATagByid(@PathParam("tagid")			String tagid) {
		// TODO Auto-generated method stub
		return "delete a tag by id:"+tagid;
	}

}
