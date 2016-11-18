package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hdu.jersey.model.GroupMessages;
import com.hdu.jersey.util.DBUtil;

/**
 * @author F-zx
 * ÈºÏûÏ¢´æ´¢dao
 * */
 public class GroupMessageDAOImpl {
	 
	 private static SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
	 
	 private static DBUtil dbutil = DBUtil.getInstance();
	 private final static String INSERT_ROW = "insert into tb_group_log(groupid,userid,createtime,content) values(?,?,?,?)";

	 public int add(GroupMessages messages){
		 System.out.println(INSERT_ROW);
		 int i  = 0;
		 Connection connection = dbutil.getConnection();
		 try {
			PreparedStatement psta = connection.prepareStatement(INSERT_ROW);
			psta.setString(1, messages.getGroupid());
			psta.setString(2, messages.getUserid());
			psta.setString(3, format.format(new Date()));
			psta.setString(4, messages.getContent());
			
			
			i = psta.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return i;
		}
		 return i;
		 
	 }
	 
	 public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		System.out.println(format.format(new Date()));
	}
}
