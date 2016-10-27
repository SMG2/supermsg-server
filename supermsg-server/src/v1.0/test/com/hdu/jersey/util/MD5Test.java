package com.hdu.jersey.util;

import org.junit.Test;

import junit.framework.TestCase;

public class MD5Test extends TestCase{

	@Test
	public void testMD5(){
		try {
            String inputStr = "ºÚµ•º”√‹8888888888888888888";   
            System.out.println(MD5.getResult(inputStr));;
       } catch (Exception e) {
           e.printStackTrace();
       }
	}
}
