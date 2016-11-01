package com.hdu.jersey.dao.impl.sql;

public class UserTagInfoSql {
	public final static String SELECT_USERS_BY_TAGID = "select * from user_tag where tagid=?";
	public final static String SELECT_TAGS_BY_USERID = "select * from user_tag where id=?";
	public final static String INSERT_TAG_FOR_USER  = "INSERT INTO user_tag values(?,?)";
	public final static String DELETE_TAG_FOR_USER  = "DELETE FROM user_tag where id=? and tagid=?";
	

}
