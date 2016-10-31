package com.hdu.jersey.error;

public final class ErrorMsg {
	public final static String RESOURCE_NOT_FOUND = "resource can not be found at anywhere.";
	public final static String USERINFO_NOT£ßFOUND = "no usersInfo had been found at database.";
	public final static String USER_ID_NULL = "userid can not be null.";
	
	public final static String NO_SCHOOLS_FOUND = "there is no schools in database.";
	public final static String NO_SCHOOL_EXIST_WITH_GIVEN_NUM = "there is no school been found by the given num";
	public final static String SCHOOL_CREATE_FAILD = "school exists.";
	public final static String SCHOOL_DELETE_FAILD = "school does not exist";
	public final static String NO_SCHOOL_ID = "do not have a school_num";
	
	public final static String TAG_ID_NULL = "tagid is null,please check your param.";
	public final static String NO_USERS_FOR_TAG = "there is no users for this tag.";
	public final static String CREATE_FAIL_FOR_TAG_EXIST = "tag is already exist.";
	
}
