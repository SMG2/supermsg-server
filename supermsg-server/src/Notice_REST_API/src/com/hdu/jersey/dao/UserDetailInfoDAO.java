package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserDetailInfo;

public interface UserDetailInfoDAO {
	
	int add();
	
	int delete(int id);
	
	int modify();
	
	ArrayList<UserDetailInfo> listDetailInfo();
}
