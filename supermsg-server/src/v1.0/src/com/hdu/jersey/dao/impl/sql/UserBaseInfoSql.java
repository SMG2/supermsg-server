package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 * 用户基础信息DAO
 *
 */
public class UserBaseInfoSql {
	/*-----------------------users-------------------------*/
	/**
	 * 添加
	 */
	public final static String ADD_USER_BASEINFO = "INSERT INTO user_baseinfo values(?,?,?,?,?,?,?) ";
	/**
	 * 删除
	 */
	public final static String DELETE_USER_BASEINFO_BY_ID = "DELETE FROM user_baseinfo where id = ?";
	/**
	 * 修改
	 */
	public final static String MODIFY_USER_BASEINFO = "UPDATE user_baseinfo SET ID=?,school_num=?,nation=?,st_num=?,pwd=?,sex=?,name=? where id=?";
	/**
	 * 查询特定用户
	 */
	public final static String SHOW_USERBASEINFO = "SELECT * FROM user_baseinfo where id=?";
	/**
	 * 查询全部
	 */
	public final static String SHOW_ALL_USERBASEINFO = "SELECT * FROM user_baseinfo";
}
