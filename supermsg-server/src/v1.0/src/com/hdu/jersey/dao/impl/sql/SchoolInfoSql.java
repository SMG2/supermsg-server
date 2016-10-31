package com.hdu.jersey.dao.impl.sql;

public final class SchoolInfoSql {
	public final static String INSERT_IN_TABLE = "INSERT INTO school_info values(?,?)";
	public final static String DELETE_BY_SCHOOLNUM = "DELETE FROM school_info where school_num=?";
	public final static String SELECT_ALL_SCHOOLS = "SELECT * FROM school_info";
	public final static String SELECT_BY_NUM = "SELECT * FROM school_info where school_num=?";
}
