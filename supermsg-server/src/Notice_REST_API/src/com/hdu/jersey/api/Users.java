package com.hdu.jersey.api;

public interface Users {
	
	public String getUsers();
	
	public String getUser(String id);
	
	public String deleteUser(String id);
	
	public String createUser();
	
	public String modify(String id);
}

