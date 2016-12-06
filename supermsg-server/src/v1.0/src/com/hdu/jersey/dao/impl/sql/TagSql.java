package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 *
 *标签sql语句
 */
public class TagSql {

	/**
	 * 创建
	 */
	public final static String CREATE_TAG = "insert into tag values(?,?)";
	
	/**
	 * 查询
	 */
	public final static String SELECT_BY_ID = "select * from tag where tagid=?";
}
