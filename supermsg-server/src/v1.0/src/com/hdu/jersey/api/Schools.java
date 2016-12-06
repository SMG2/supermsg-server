package com.hdu.jersey.api;

import com.hdu.jersey.model.SchoolInfo;


/**
 * ѧУ�ӿڣ�ѧУ��Ϣ��CRUD
 * 
 * */
public interface Schools {

	/**
	 * 	�������е�ѧУ��Ϣ����Ҫ������ȥץȡ��
	 * 
	 * */
	public String getAllSchools();
	
	/**
	 * 	���һ��ѧУ����Ϣ
	 * 
	 * */
	public String getSchoolInfoByNum(String school_num
			);
	
	/**
	 * 	����һ��school
	 * 
	 * */
	public String createSchool(SchoolInfo info);
	
	/**
	 * ͨ��ѧУ���ɾ��ѧУ
	 * 
	 * */
	public String deleteSchoolByNum(String school_num
			);
}



