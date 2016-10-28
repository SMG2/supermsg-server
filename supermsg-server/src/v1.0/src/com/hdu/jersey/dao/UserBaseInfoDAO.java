package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserBaseInfo;

/**
 * 	@author F-zx
 * 	
 * 用户基础信息类dao用户处理数据CRUD
 * 
 * */
public interface UserBaseInfoDAO {

	int add(UserBaseInfo info);
	
	int delete(String id);
	
	/**
	 * @param reinfo 需要更改的用户信息
	 * */
	int modify(UserBaseInfo reInfo);
	
	ArrayList<UserBaseInfo> listBaseInfo();
	
	UserBaseInfo showByid(String id);
}
