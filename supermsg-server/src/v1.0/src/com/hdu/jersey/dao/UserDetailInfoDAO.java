package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserDetailInfo;

/**
 * 用户详细信息DAO层申明
 * 
 * */
public interface UserDetailInfoDAO {
	
	/**
	 * 添加
	 * */
	int add(UserDetailInfo info);
	/**
	 * 删除
	 * */
	int delete(String id);
	/**
	 * 修改
	 * */
	int modify();
	/**
	 * 获取特定用户信息
	 * */
	UserDetailInfo getDetail(String userid);
	/**
	 * 获取所有的用户
	 * */
	ArrayList<UserDetailInfo> listDetailInfo();
	
	String getUserGroupByUserid(String userid);
}
