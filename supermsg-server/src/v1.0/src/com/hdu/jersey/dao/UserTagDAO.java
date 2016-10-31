package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserTag;

public interface UserTagDAO {
	
	public ArrayList<UserTag> getUsersByTagId(String tagid);
	
}
