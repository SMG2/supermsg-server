package com.hdu.jersey.dao.impl.sql;

public class UserDetailInfoSql {
	public final static String INSERT_USER_DETAIL = "INSERT INTO user_detailinfo values(?,?,?,?,?,?)";
	public final static String SELECT_ALL = "select * from user_detailinfo where id=?";
	
	public final static String QUERY_USERID_BY_CLASS = "select id from user_detailinfo where class=?";

}
