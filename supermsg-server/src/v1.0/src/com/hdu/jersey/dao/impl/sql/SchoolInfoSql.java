package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 *
 */
public final class SchoolInfoSql {
	/**
	 * ������Ϣ
	 */
	public final static String INSERT_IN_TABLE = "INSERT INTO school_info values(?,?)";
	/**
	 * ����idɾ��
	 */
	public final static String DELETE_BY_SCHOOLNUM = "DELETE FROM school_info where school_num=?";
	/**
	 * ��ѯ������Ϣ
	 */
	public final static String SELECT_ALL_SCHOOLS = "SELECT * FROM school_info";
	/**
	 * ͨ��ѧУ��Ų�ѯѶ
	 */
	public final static String SELECT_BY_NUM = "SELECT * FROM school_info where school_num=?";
}
