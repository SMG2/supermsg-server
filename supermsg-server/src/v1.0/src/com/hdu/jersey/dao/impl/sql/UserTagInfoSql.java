package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 *
 */
public class UserTagInfoSql {
	/**
	 * 查询特定标签的用户
	 */
	public final static String SELECT_USERS_BY_TAGID = "select * from user_tag where tagid=?";
	/**
	 * 查询用户特定标签
	 */
	public final static String SELECT_TAGS_BY_USERID = "select * from user_tag where id=?";
	/**
	 * 插入用户标签
	 */
	public final static String INSERT_TAG_FOR_USER  = "INSERT INTO user_tag values(?,?)";
	/**
	 * 删除
	 */
	public final static String DELETE_TAG_FOR_USER  = "DELETE FROM user_tag where id=? and tagid=?";
	

}
