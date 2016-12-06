package com.hdu.jersey.dao.impl.sql;

public class UserDetailInfoSql {
	/**
	 * 插入
	 */
	public final static String INSERT_USER_DETAIL = "INSERT INTO user_detailinfo values(?,?,?,?,?,?)";
	/**
	 * 查询全部
	 */
	public final static String SELECT_ALL = "select * from user_detailinfo where id=?";
	/**
	 * 查询群组用户
	 */
	public final static String QUERY_USERID_BY_CLASS = "select id from user_detailinfo where class=?";
	
	/**
	 * 查询用户所在群组
	 */
	public final static String QUERY_USER_GROUP_BY_USERID = "select class from user_detailinfo where id =?";

}
