package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.Tag;
import com.hdu.jersey.model.UserTag;

/**
 * 用户标签接口申明
 * */
public interface UserTagDAO {
	/**
	 * 获取一个标签的所有用户
	 * */
	public ArrayList<UserTag> getUsersByTagId(String tagid);
	
	/**
	 * 获取单个用户的所有tag
	 * */
	public ArrayList<Tag> getTagsByUserid(String userid);
	
	/**
	 * 添加用户标签
	 * */
	public boolean addTagForUser(UserTag userTag);
	
	
	/**
	 * 删除标签
	 * */
	public int delete(UserTag userTag);
	
}
