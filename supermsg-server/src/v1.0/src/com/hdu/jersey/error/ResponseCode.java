package com.hdu.jersey.error;

public final class ResponseCode {
	/**
	 * 标准返回，无错误
	 */
	public final static int OK = 200;
	/**
	 * 未授权
	 */
	public final static int UNAUTHORIZED = 401;
	/**
	 * 资源未找到
	 */
	public final static int RESOURCE_NOT_FOUND = 404;
	
	/**
	 * 用户id未空
	 */
	public final static int USER_ID_NULL = 400;
	/**
	 * 删除错误
	 */
	public final static int USER_DELETE_ERROR = 405;
	/**
	 * 用于已经存在
	 */
	public final static int USER_EXIST= 402;
	/**
	 * 用户无法找到
	 */
	public final static int USER_NOT_EXIST= 406;
	/**
	 * 用户标签未空
	 */
	public final static int USER_TAG_NOT_SET= 407;
	/**
	 * 设置错误
	 */
	public final static int FAIL_TOADD_TAG_FOR_USER= 4081;
	/**
	 * 删除错误
	 */
	public final static int FAIL_DELETE_TAG_FOR_USER= 4082;
	
	/**
	 * 失败注册到openfire
	 */
	public final static int FAIL_TO_REGIST_IN_OPENGIRE = 409;
	
	/**
	 * 无学校
	 */
	public final static int NO_SCHOOLS_FOUND = 410;
	public final static int NO_SCHOOL_EXIST_WITH_GIVEN_NUM = 411;
	public final static int SCHOOL_CREATE_FAILD = 412;
	public final static int SCHOOL_DELETE_FAILD = 413;
	public final static int NO_SCHOOL_ID = 414;
	
	public final static int TAG_ID_NULL  = 420;
	public final static int NO_USERS_FOR_TAG = 421;
	public final static int CREATE_FAIL_FOR_TAG_EXIST = 422;
	
	
	public final static int WRONG_PWD_OR_STNUM = 430;
	
	public final static int USER_IS_NOT_OFFLINE = 440;
	
	public final static int PUSH_TAGS_BE_NULL = 460;
	
	public final static int UNDEFINED_ACTION = 470;
	
	public final static int ENCRYP_ERROR = 480;
	public final static int DECRYP_ERROR = 481;
	
	public final static int NO_KEY_FOUND_IN_REDIS = 490;
	
	
	
	
}
