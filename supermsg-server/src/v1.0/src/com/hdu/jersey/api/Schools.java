package com.hdu.jersey.api;

import com.hdu.jersey.model.SchoolInfo;


/**
 * 学校接口，学校信息的CRUD
 * 
 * */
public interface Schools {

	/**
	 * 	返回所有的学校信息（需要从网上去抓取）
	 * 
	 * */
	public String getAllSchools();
	
	/**
	 * 	获得一个学校的信息
	 * 
	 * */
	public String getSchoolInfoByNum(String school_num
			);
	
	/**
	 * 	创建一个school
	 * 
	 * */
	public String createSchool(SchoolInfo info);
	
	/**
	 * 通过学校编号删除学校
	 * 
	 * */
	public String deleteSchoolByNum(String school_num
			);
}



