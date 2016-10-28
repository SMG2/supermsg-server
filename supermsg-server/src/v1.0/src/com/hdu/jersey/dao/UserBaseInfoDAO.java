package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserBaseInfo;

/**
 * 	@author F-zx
 * 	
 * �û�������Ϣ��dao�û���������CRUD
 * 
 * */
public interface UserBaseInfoDAO {

	int add(UserBaseInfo info);
	
	int delete(String id);
	
	/**
	 * @param reinfo ��Ҫ���ĵ��û���Ϣ
	 * */
	int modify(UserBaseInfo reInfo);
	
	ArrayList<UserBaseInfo> listBaseInfo();
	
	UserBaseInfo showByid(String id);
}
