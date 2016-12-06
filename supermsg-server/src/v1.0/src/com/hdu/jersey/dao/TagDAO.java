package com.hdu.jersey.dao;

import com.hdu.jersey.model.Tag;

/**
 * @author zhuxin
 *标签CRUD
 */
public interface TagDAO {

	/**
	 * 创建
	 * */
	public int createTag(Tag tag);
	
	/**
	 * 查询特定标签信息
	 * @param tagid 标签id
	 * @return 返回一个标签对象
	 */
	public Tag select(String tagid);
}
