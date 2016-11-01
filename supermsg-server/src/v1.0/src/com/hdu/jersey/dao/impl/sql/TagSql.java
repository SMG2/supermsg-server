package com.hdu.jersey.dao.impl.sql;

public class TagSql {

	public final static String CREATE_TAG = "insert into tag values(?,?)";
	
	public final static String SELECT_BY_ID = "select * from tag where tagid=?";
}
