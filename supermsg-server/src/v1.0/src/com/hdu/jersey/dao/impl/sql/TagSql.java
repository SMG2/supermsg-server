package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 *
 *��ǩsql���
 */
public class TagSql {

	/**
	 * ����
	 */
	public final static String CREATE_TAG = "insert into tag values(?,?)";
	
	/**
	 * ��ѯ
	 */
	public final static String SELECT_BY_ID = "select * from tag where tagid=?";
}
