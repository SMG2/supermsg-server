package dao.test;

import org.junit.Test;

import com.hdu.jersey.dao.impl.UserBaseInfoDAOImpl;
import com.hdu.jersey.model.UserBaseInfo;

public class UserBaseInfoTest {
	UserBaseInfoDAOImpl user = new UserBaseInfoDAOImpl();
	
	@Test
	public void addUser(){
		UserBaseInfo info  = new UserBaseInfo();
		user.add(info);
	}
	
	@Test
	public void deleteUser(){
		System.out.println(user.delete("1"));
	}

}
