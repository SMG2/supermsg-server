package com.hdu.jersey.api;

import com.hdu.jersey.model.UserCreateModel;

public interface Users {
	
	/**
	 * 		活的所有的用户
	 * */
	public String getUsers();
	
	/**
	 * 	获得用户信息by用户的id
	 * @param id 用户id
	 * 
	 * */
	public String getUserByUserid(String id
			);
	
	/**
	 * 	删除用户通过用户id
	 * @param id 用户id
	 * 	
	 * */
	public String deleteUser(String id
			);
	
	
	/**
	 * 
	 * 创建用户
	 * */
	public String createUser(UserCreateModel model);
	
	
	/**XXXXXXXX
	 * 	修改用户，如果用户不存在就创建改用户
	 * */
	public String modify(String id
			);
	
	
	/**
	 * 获得用户详细信息
	 * 
	 * */
	public String getUserDetailInfo(String userid
			);
	
/******************************************************tag管理****************************************************************************/

	/**
	 * 获得某个用户的tag标签
	 * 
	 * */
	public String getUserTags(String userid
			);
	
	/**
	 * 	为某个用户创建一个tag
	 * 
	 * @param userid 用户id
	 * @param tagid 标签
	 * 
	 * */
	public String createTagforUser(String userid,String tagid
			);
	
	/**
	 * 	删除用户的标签
	 * 
	 * @param userid  用户id
	 * @param tagid 标签id
	 * 
	 * */
	public String deleteUserTag(String userid,String tagid
			);
	

}

