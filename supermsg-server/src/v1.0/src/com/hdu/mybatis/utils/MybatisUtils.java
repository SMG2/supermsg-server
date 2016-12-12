package com.hdu.mybatis.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hdu.jersey.model.UseridAndPwd;

public class MybatisUtils {

	public static SqlSession getSession(){
		String resource = "conf.xml";
		InputStream is = MybatisUtils.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory.openSession();
		
	}
	
	public static void closeSession(SqlSession session){
		if(session != null){
			session.close();
		}
	}
	
	public static void main(String[] args) {
		SqlSession session = MybatisUtils.getSession();
		String statement = "com.hdu.jersey.model.authUser";
		UseridAndPwd model = session.selectOne(statement, "17764591353");
		System.out.println(model.getPassword());
	}
}
