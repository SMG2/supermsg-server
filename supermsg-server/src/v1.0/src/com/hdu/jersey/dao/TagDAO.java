package com.hdu.jersey.dao;

import com.hdu.jersey.model.Tag;

/**
 * @author zhuxin
 *��ǩCRUD
 */
public interface TagDAO {

	/**
	 * ����
	 * */
	public int createTag(Tag tag);
	
	/**
	 * ��ѯ�ض���ǩ��Ϣ
	 * @param tagid ��ǩid
	 * @return ����һ����ǩ����
	 */
	public Tag select(String tagid);
}
