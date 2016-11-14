package com.hdu.openfire;

import org.junit.Test;

import com.hdu.openfire.regist.UserRegister;

public class RegisterTest {

	@Test
	public void test() {
	
		UserRegister register = new UserRegister();
		System.out.println(register.regist("52322", "23"));
		
	}

}
