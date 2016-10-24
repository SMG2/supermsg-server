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
{"face":"共青团员","role":"学生","major":"软件工程","nation":"汉族","grade":"2014","sex":"男","name":"朱鑫","class":"14108414","academy":"计算机学院"}
		 */
		
	}

}
