package com.hdu.test;

import java.io.IOException;

import org.junit.Test;

import assist.main.CheckStudent;

public class TestUser {
	
	@Test
	public void test() throws IOException{
		CheckStudent checkStudent = new CheckStudent("14108438", "Hdu1247430");
		checkStudent.login();
		System.out.println(checkStudent.getInfo().toString());
		
		/*
{"role":"ѧ��","major":"�������","grade":"2014","sex":"��","class":"14108414","academy":"�����ѧԺ"}
		 */
		
	}

}
