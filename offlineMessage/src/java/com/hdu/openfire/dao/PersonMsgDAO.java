package com.hdu.openfire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdu.openfire.dbutil.DBUtil;

public class PersonMsgDAO {
	private static DBUtil dbUtil = DBUtil.getInstance();
	
	private final static String PERSON_INSERT = "insert into tb_person_msg values(?,?,?,?,?,?,?)";
	/*
	MESSAGEID INT PRIMARY KEY,
	SESSIONJID VARCHAR (30),
	SENDER VARCHAR (30),
	RECEIVER VARCHAR (30),
	CREATEDATE VARCHAR (30),
	CONTENT VARCHAR (2000),
	DETAIL VARCHAR (4000) 
	 */
	private final static String GROUP_INSERT = "insert into tb_group_msg values()";
	private final static String IS_EXIST_PK = "SELECT MESSAGEID FROM tb_person_msg where MESSAGEID=?";
	
	public void addp2p(String msgid,String sessionid,String sender,String receiver,String createtime, String content,String detail){
		Connection connection = dbUtil.getConnection();
		
		System.out.println(PERSON_INSERT);
		try {
			PreparedStatement psta = connection.prepareStatement(PERSON_INSERT);
			psta.setString(1, msgid);
			psta.setString(2, sessionid);
			psta.setString(3, sender);
			psta.setString(4, receiver);
			psta.setString(5, createtime);
			psta.setString(6, content);
			psta.setString(7, detail);
			
			psta.executeUpdate();
			psta.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeConnection();
		}
		
	}
	
	/**
	 * select id from tb to determine whether to continue .
	 * @return TRUE is for exist
	 * 
	 * */
	public boolean isExist(String msg_id){
		Connection connection = dbUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement psta = null;
		try {
			psta = connection.prepareStatement(IS_EXIST_PK);
			psta.setString(1, msg_id);
			
			rs = psta.executeQuery();
			
//			return rs.next();
			if(rs.next()){
				System.out.println(rs.getString("MESSAGEID"));
				return true;
			}else {
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				if(rs != null)
					rs.close();
				if(psta != null)
					psta.close();
			} catch (SQLException e) {
				System.out.println("close error.");
			}
		}
	}

}
