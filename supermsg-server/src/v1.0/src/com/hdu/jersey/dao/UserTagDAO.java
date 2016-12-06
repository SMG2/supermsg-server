package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.Tag;
import com.hdu.jersey.model.UserTag;

/**
 * �û���ǩ�ӿ�����
 * */
public interface UserTagDAO {
	/**
	 * ��ȡһ����ǩ�������û�
	 * */
	public ArrayList<UserTag> getUsersByTagId(String tagid);
	
	/**
	 * ��ȡ�����û�������tag
	 * */
	public ArrayList<Tag> getTagsByUserid(String userid);
	
	/**
	 * ����û���ǩ
	 * */
	public boolean addTagForUser(UserTag userTag);
	
	
	/**
	 * ɾ����ǩ
	 * */
	public int delete(UserTag userTag);
	
}
