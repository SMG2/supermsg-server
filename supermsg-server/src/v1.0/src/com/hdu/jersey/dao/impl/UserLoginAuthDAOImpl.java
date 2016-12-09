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
	 * @return 返回true 或者FALSE
	 * */
	public boolean authUser(UseridAndPwd model){
		boolean rel = false;
		if("".equals(model.getPassword()) || model.getPassword() == null)
			return rel;
		
		SqlSession session = MybatisUtils.getSession();
		UseridAndPwd rs = session.selectOne(STATEMENT_USERLOGIN_AUTH, model.getUserid());
		
		if(rs != null && model.getPassword().equals(rs.getPassword()))
			rel = true;
		return rel;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new UserLoginAuthDAOImpl().authUser(new UseridAndPwd("103361408412","4444")));
	}
}
