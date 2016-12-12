package com.hdu.jersey.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.hdu.jersey.model.UseridAndPwd;
import com.hdu.mybatis.utils.MybatisUtils;

/**
 * @author F-zx
 * 
 * 用mybatis查询用户密码以及用户id然后验证
 * */
public class UserLoginAuthDAOImpl {
	
	private final static String STATEMENT_USERLOGIN_AUTH = "com.hdu.jersey.model.authUser";
	

	/**
	 * @param model 用户model
	 * 
	 * @return 返回null或者对象
	 * */
	public UseridAndPwd authUser(UseridAndPwd model){
		if("".equals(model.getPassword()) || model.getPassword() == null)
			return null;
		
		SqlSession session = MybatisUtils.getSession();
		UseridAndPwd rs = session.selectOne(STATEMENT_USERLOGIN_AUTH, model.getPhoneNum());
		
		if(rs != null && model.getPassword().equals(rs.getPassword()))
			return rs;
		return null;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new UserLoginAuthDAOImpl().authUser(new UseridAndPwd("17764591320","4444")).toString());
	}
}
