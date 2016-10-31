package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.SchoolInfo;

public interface SchoolInfoDAO {

	int add(SchoolInfo info);
	
	int delete(String id);
	
	@Deprecated
	int modify();
	
	ArrayList<SchoolInfo> listSchools();
	
	SchoolInfo getInfoByNum(String school_num);
}
