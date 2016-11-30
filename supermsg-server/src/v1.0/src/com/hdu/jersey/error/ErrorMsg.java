package com.hdu.jersey.error;

public final class ErrorMsg {
	public final static String RESOURCE_NOT_FOUND = "resource can not be found at anywhere.";
	public final static String USERINFO_NOT£ßFOUND = "no usersInfo had been found at database.";
	public final static String USER_ID_NULL = "userid can not be null.";
	public final static String USER_EXIST = "user is already registed.";
	public final static String USER_NOT_EXIST = "user not exist.";
	public final static String USER_TAG_NOT_SET = "you have not set a tag to the user.";
	
	public final static String FAIL_TO_REGIST_IN_OPENGIRE = "fail to regist in openfire.";
	
	public final static String NO_SCHOOLS_FOUND = "there is no schools in database.";
	public final static String NO_SCHOOL_EXIST_WITH_GIVEN_NUM = "there is no school been found by the given num";
	public final static String SCHOOL_CREATE_FAILD = "school exists.";
	public final static String SCHOOL_DELETE_FAILD = "school does not exist";
	public final static String NO_SCHOOL_ID = "do not have a school_num";
	
	public final static String TAG_ID_NULL = "tagid is null,please check your param.";
	public final static String NO_USERS_FOR_TAG = "there is no users for this tag.";
	public final static String CREATE_FAIL_FOR_TAG_EXIST = "tag is already exist.";
	
	public final static String WRONG_PWD_OR_STNUM = "wrong student num or student password.please check and retry.";
	
	public final static String EMPTY_TAGS_OR_TAGS_NOT_SET_WHEN_PUSHING = "empty tags or tags not set while pushing msg.";
	
}
