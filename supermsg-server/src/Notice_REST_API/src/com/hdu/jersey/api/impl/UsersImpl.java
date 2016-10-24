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
	
	@Override
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {
		return "all users";
	}

	@Override
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userid}")
	public String getUser(@PathParam("userid")String userid) {
		return "one :"+userid;
	}
	
	
	@Override
	@DELETE
	@Path("/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("userid")String userid){
		return "delete user by id."+userid;
	}
	

	@Override
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createUser() {
		return "create user by post";
	}
	
	@Override
	@PUT
	@Path("{userid}")
	public String modify(@PathParam("userid")String userid) {
		
		return "modify user by id."+userid;
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
