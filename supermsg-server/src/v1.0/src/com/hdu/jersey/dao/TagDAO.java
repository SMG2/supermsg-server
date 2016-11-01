package com.hdu.jersey.dao;

import com.hdu.jersey.model.Tag;

public interface TagDAO {

	public int createTag(Tag tag);
	
	public Tag select(String tagid);
}
