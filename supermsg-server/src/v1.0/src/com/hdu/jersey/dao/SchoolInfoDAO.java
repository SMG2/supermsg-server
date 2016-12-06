package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.SchoolInfo;

/**
 * @author zhuxin
 * 学校信息DAO层申明
 *
 */
public interface SchoolInfoDAO {

	/**
	 * 添加
	 * @param info school对象
	 * @return 执行结果1,0
	 */
	int add(SchoolInfo info);
	
	/**删除
	 * @param id 学校id
	 * @return 返回1,0
	 */
	int delete(String id);
	
	/**修改
	 * @return
	 */
	@Deprecated
	int modify();
	
	/**
	 * 获取所有学校信息List
	 * @return
	 */
	ArrayList<SchoolInfo> listSchools();
	
	/**
	 * 获取特定信息
	 * @param school_num 学校编号
	 * @return 学校对象
	 */
	SchoolInfo getInfoByNum(String school_num);
}
