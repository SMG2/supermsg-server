package com.hdu.jersey.dao.impl.sql;

/**
 * @author zhuxin
 *
 */
public class UserTagInfoSql {
	/**
	 * ��ѯ�ض���ǩ���û�
	 */
	public final static String SELECT_USERS_BY_TAGID = "select * from user_tag where tagid=?";
	/**
	 * ��ѯ�û��ض���ǩ
	 */
	public final static String SELECT_TAGS_BY_USERID = "select * from user_tag where id=?";
	/**
	 * �����û���ǩ
	 */
	public final static String INSERT_TAG_FOR_USER  = "INSERT INTO user_tag values(?,?)";
	/**
	 * ɾ��
	 */
	public final static String DELETE_TAG_FOR_USER  = "DELETE FROM user_tag where id=? and tagid=?";
	

}
