package com.hdu.jersey.api.impl;

public class UsersImpl implements com.hdu.jersey.api.Users {
	
	@Override
	public String getUsers() {
		return "all users";
	}

	@Override
	public String getUserByUserid(String userid) {
		return "one :"+userid;
	}
	
	
	@Override
	public String deleteUser(String userid){
		return "delete user by id."+userid;
	}
	

	@Override
	public String createUser() {
		return "create user by post";
	}
	
	@Override
	public String modify(String userid) {
		
		return "modify user by id."+userid;
	}

	@Override
	public String getUserTags(String id) {
		return "the "+id+"'s tag is tags.";
	}

	@Override
	public String createTagforUser(String userid, String tagName) {
		return "create a tag:"+tagName+"for "+userid;
	}

	@Override
	public String deleteUserTag(String userid, String tagName) {
		return "delete a tag:"+tagName+"for "+userid;
	}
	

	@Override
	public String getUserDetailInfo(String userid) {
		return "get "+userid+"'s detail infomation.";
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
