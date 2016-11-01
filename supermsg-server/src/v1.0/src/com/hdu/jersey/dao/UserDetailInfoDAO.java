package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserDetailInfo;

public interface UserDetailInfoDAO {
	
	int add(UserDetailInfo info);
	
	int delete(String id);
	
	int modify();
	
	UserDetailInfo getDetail(String userid);
	
	ArrayList<UserDetailInfo> listDetailInfo();
}
