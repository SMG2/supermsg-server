package com.hdu.jersey.error;

public final class ResponseCode {
	public final static int OK = 200;
	public final static int RESOURCE_NOT_FOUND = 404;
	
	public final static int USER_ID_NULL = 400;
	public final static int USER_DELETE_ERROR = 401;
	
	public final static int NO_SCHOOLS_FOUND = 410;
	public final static int NO_SCHOOL_EXIST_WITH_GIVEN_NUM = 411;
	public final static int SCHOOL_CREATE_FAILD = 412;
	public final static int SCHOOL_DELETE_FAILD = 413;
	public final static int NO_SCHOOL_ID = 414;
	
	public final static int TAG_ID_NULL  = 420;
	public final static int NO_USERS_FOR_TAG = 421;
	public final static int CREATE_FAIL_FOR_TAG_EXIST = 422;
	
}
