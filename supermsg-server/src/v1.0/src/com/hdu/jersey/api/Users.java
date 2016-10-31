package com.hdu.jersey.api;

import com.hdu.jersey.model.UserCreateModel;

public interface Users {
	
	/**
	 * 		������е��û�
	 * */
	public String getUsers();
	
	/**
	 * 	����û���Ϣby�û���id
	 * @param id �û�id
	 * 
	 * */
	public String getUserByUserid(String id
			);
	
	/**
	 * 	ɾ���û�ͨ���û�id
	 * @param id �û�id
	 * 	
	 * */
	public String deleteUser(String id
			);
	
	
	/**
	 * 
	 * �����û�
	 * */
	public String createUser(UserCreateModel model);
	
	
	/**XXXXXXXX
	 * 	�޸��û�������û������ھʹ������û�
	 * */
	public String modify(String id
			);
	
	
	/**
	 * ����û���ϸ��Ϣ
	 * 
	 * */
	public String getUserDetailInfo(String userid
			);
	
/******************************************************tag����****************************************************************************/

	/**
	 * ���ĳ���û���tag��ǩ
	 * 
	 * */
	public String getUserTags(String userid
			);
	
	/**
	 * 	Ϊĳ���û�����һ��tag
	 * 
	 * @param userid �û�id
	 * @param tagid ��ǩ
	 * 
	 * */
	public String createTagforUser(String userid,String tagid
			);
	
	/**
	 * 	ɾ���û��ı�ǩ
	 * 
	 * @param userid  �û�id
	 * @param tagid ��ǩid
	 * 
	 * */
	public String deleteUserTag(String userid,String tagid
			);
	

}

