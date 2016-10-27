package com.hdu.jersey.api.impl;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsersImpl implements com.hdu.jersey.api.Users {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {
		return "all users";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userid}")
	@Override
	public String getUserByUserid(@PathParam("userid")			String userid) {
		return "one :"+userid;
	}
	

	@DELETE
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)	
	@Override
	public String deleteUser(@PathParam("userid")			String userid){
		return "delete user by id."+userid;
	}
	

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String createUser() {
		return "create user by post";
	}

	@PUT
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String modify(@PathParam("userid")			String userid) {
		
		return "modify user by id."+userid;
	}

	@GET
	@Path("/{userid}/detail")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getUserDetailInfo(@PathParam("userid")			String userid) {
		return "get "+userid+"'s detail infomation.";
	}

	@GET
	@Path("/{userid}/tags")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getUserTags(@PathParam("userid")			String id) {
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
		return "delete a tag:"+tagid+"for "+userid;
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
