package com.hdu.jersey.util;

import java.io.IOException;

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
 * 懒加载
 * 
 * */
public class GetStudentInfo {
	private boolean success = false;
	
	UserBaseInfo baseInfo = new UserBaseInfo();
	UserDetailInfo detailInfo = new UserDetailInfo();
	
	JSONObject object = null;
	
	private String id;
	private String st_num;
	private String st_pwd;
	
	private String pwd;
	private String phone;
	private String school_num;
	
//	private boolean 
	
	private static GetStudentInfo getUtil;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public UserBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(UserBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public UserDetailInfo getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(UserDetailInfo detailInfo) {
		this.detailInfo = detailInfo;
	}

	private GetStudentInfo(String st_num,String st_pwd,String pwd,String phone,String school_num){
		
		this.id = school_num+st_num;
		this.phone = phone;
		this.pwd = pwd;
		this.school_num = school_num;
		this.st_pwd = st_pwd;
		this.st_num = st_num;
	}
	
	public static GetStudentInfo getInstance(String st_num,String st_pwd,String pwd,String phone,String school_num){
		getUtil = new GetStudentInfo(st_num, st_pwd, pwd, phone, school_num);
		return getUtil;
	}
	
	/**
	 * 网上爬取信息，然后调用load方法进行封装，加载
	 * 
	 * */
	public void spideFromWebAndLoad(){
		CheckStudent checkStudent = new CheckStudent(st_num, st_pwd);
		try {
			success = checkStudent.login();
			if(!success)
				return ;
		} catch (IOException e) {
			return ;
		}
		object = checkStudent.getInfo();
		System.out.println(object.toString());
		load();
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
//		detailInfo.setCla("14108414");
		detailInfo.setCollege(object.getString("academy"));
		detailInfo.setGrade(object.getString("grade"));
		detailInfo.setId(this.id);
//		detailInfo.setMail(mail);
		detailInfo.setMajor(object.getString("major"));
		detailInfo.setPhone(this.phone);
	}
	
}


