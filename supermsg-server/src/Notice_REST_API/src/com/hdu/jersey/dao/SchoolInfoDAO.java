package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.SchoolInfo;

public interface SchoolInfoDAO {

	int add();
	
	int delete(int id);
	
	int modify();
	
	ArrayList<SchoolInfo> listSchools();
}
