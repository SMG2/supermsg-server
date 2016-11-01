package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.Tag;
import com.hdu.jersey.model.UserTag;

public interface UserTagDAO {
	
	public ArrayList<UserTag> getUsersByTagId(String tagid);
	
	public ArrayList<Tag> getTagsByUserid(String userid);
	
	public boolean addTagForUser(UserTag userTag);
	
	public int delete(UserTag userTag);
	
}
