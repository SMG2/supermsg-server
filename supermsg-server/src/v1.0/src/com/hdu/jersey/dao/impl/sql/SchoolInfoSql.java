package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 *
 */
public final class SchoolInfoSql {
	/**
	 * 插入信息
	 */
	public final static String INSERT_IN_TABLE = "INSERT INTO school_info values(?,?)";
	/**
	 * 根据id删除
	 */
	public final static String DELETE_BY_SCHOOLNUM = "DELETE FROM school_info where school_num=?";
	/**
	 * 查询所有信息
	 */
	public final static String SELECT_ALL_SCHOOLS = "SELECT * FROM school_info";
	/**
	 * 通过学校编号查询讯
	 */
	public final static String SELECT_BY_NUM = "SELECT * FROM school_info where school_num=?";
}
