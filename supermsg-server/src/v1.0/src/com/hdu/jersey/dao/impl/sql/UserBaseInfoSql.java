package com.hdu.jersey.dao.impl.sql;

public class UserBaseInfoSql {
	public final static String ADD_USER_BASEINFO = "INSERT INTO user_baseinfo values(?,?,?,?,?,?,?) ";
	public final static String DELETE_USER_BASEINFO_BY_ID = "DELETE FROM user_baseinfo where id = ?";
	public final static String MODIFY_USER_BASEINFO = "UPDATE user_baseinfo SET ID=?,school_num=?,nation=?,st_num=?,pwd=?,sex=?,name=? where id=?";
	public final static String SHOW_USERBASEINFO = "SELECT * FROM user_baseinfo where id=?";
	public final static String SHOW_ALL_USERBASEINFO = "SELECT * FROM user_baseinfo";
}
