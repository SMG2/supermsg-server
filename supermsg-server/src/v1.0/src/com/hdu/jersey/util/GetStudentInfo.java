package com.hdu.jersey.util;

import java.io.IOException;

import com.hdu.jersey.dao.impl.SchoolInfoDAOImpl;
import com.hdu.jersey.model.UserBaseInfo;
import com.hdu.jersey.model.UserDetailInfo;

import assist.main.CheckStudent;
import net.sf.json.JSONObject;

//import assist.main.CheckStudent;
//
//CheckStudent checkStudent = new CheckStudent("14108438", "Hdu1247430");
//checkStudent.login();
//System.out.println(checkStudent.getInfo().toString());
//


/**
 * ������
 * 
 * */
public class GetStudentInfo {
	private boolean success = false;
	
	UserBaseInfo baseInfo = new UserBaseInfo();
	UserDetailInfo detailInfo = null;
	
	JSONObject object = null;
	
	private String id;
	private String st_num;
	private String st_pwd;
	
	private String pwd;
	private String phone;
	private String school_num;
	
//	private boolean 
	
	private GetStudentInfo getUtil;

	private GetStudentInfo(String st_num,String st_pwd,String pwd,String phone,String school_num){
		
		this.id = school_num+st_num;
		this.phone = phone;
		this.pwd = pwd;
		this.school_num = school_num;
		this.st_pwd = st_pwd;
		this.st_num = st_num;
	}
	
	public GetStudentInfo getInstance(String st_num,String st_pwd,String pwd,String phone,String school_num){
		getUtil = new GetStudentInfo(st_num, st_pwd, pwd, phone, school_num);
		return getUtil;
	}
	
	/**
	 * ������ȡ��Ϣ��Ȼ�����load�������з�װ������
	 * 
	 * */
	public void spideFromWebAndLoad(){
		CheckStudent checkStudent = new CheckStudent(st_num, st_pwd);
		try {
			success = checkStudent.login();
		} catch (IOException e) {
			return ;
		}
		object = checkStudent.getInfo();
		///*
		//{"face":"������Ա","role":"ѧ��","major":"�������","nation":"����","grade":"2014","sex":"��","name":"����","class":"14108414","academy":"�����ѧԺ"}
		// */

	}
	
	private void load(){
		
		baseInfo.setId(this.id);
		baseInfo.setName(object.getString("name"));
		baseInfo.setNation(object.getString("nation"));
		baseInfo.setPwd(pwd);
		baseInfo.setSchool_num(school_num);
		baseInfo.setSex(object.getString("sex"));
		baseInfo.setSt_num(st_num);
		
		detailInfo.setCla(object.getString("class"));
		detailInfo.setCollege(object.getString("academy"));
		detailInfo.setGrade(object.getString("grade"));
		detailInfo.setId(this.id);
//		detailInfo.setMail(mail);
		detailInfo.setMajor(object.getString("major"));
		detailInfo.setPhone(this.phone);
	}
	
}


