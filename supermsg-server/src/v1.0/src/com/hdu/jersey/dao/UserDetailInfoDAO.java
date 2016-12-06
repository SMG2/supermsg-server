package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.UserDetailInfo;

/**
 * �û���ϸ��ϢDAO������
 * 
 * */
public interface UserDetailInfoDAO {
	
	/**
	 * ���
	 * */
	int add(UserDetailInfo info);
	/**
	 * ɾ��
	 * */
	int delete(String id);
	/**
	 * �޸�
	 * */
	int modify();
	/**
	 * ��ȡ�ض��û���Ϣ
	 * */
	UserDetailInfo getDetail(String userid);
	/**
	 * ��ȡ���е��û�
	 * */
	ArrayList<UserDetailInfo> listDetailInfo();
	
	String getUserGroupByUserid(String userid);
}
