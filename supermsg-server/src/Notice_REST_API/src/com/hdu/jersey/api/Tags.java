package com.hdu.jersey.api;

import com.hdu.jersey.model.Tag;

/**
 * 	������ô���
 * 	1���г��û�������tags���ŵ�users�У�
 * 	2���г�һ��tag�������û�
 * 	3��ɾ��ĳ���û���tag���ŵ�users��ȥ��
 * 	4��Ϊ�û�����һ��tag���ŵ�users��ȥ��
 * 
 * */
public interface Tags {
	
	/**
	 * ���һ��tag�Ķ���û�
	 * 
	 * */
	public String getAllTagsByUserId(String tagid
			);
	
	/**
	 * ����һ��tag
	 * ������
	 * 
	 * */
	public String craeteNewTag(Tag tag);
	
	
	/**
	 * ɾ��һ��tag����ñ��ã���Ϊtag��user�ĸ��ϣ�Ϊuser���һ��tag���������tag����ʹ�õ��У�
	 * 
	 * */
	public String deleteATagByid(String tagid
			);
	
	
	
}