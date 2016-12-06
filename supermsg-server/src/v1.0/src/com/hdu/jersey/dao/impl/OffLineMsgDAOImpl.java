package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hdu.jersey.model.P2PMsg;
import com.hdu.jersey.util.DBUtil;

/**
 * 离线消息DAO层实现
 * */
public class OffLineMsgDAOImpl {
	
	private static DBUtil dbutil = DBUtil.getInstance();
	
	private final static String GET_OFF_LINE_MSG_PERSON = "SELECT MESSAGEID,SENDER,RECEIVER,CONTENT,CREATEDATE from tb_person_msg where RECEIVER=? and CREATEDATE>=?";
	
	/**
	 * 先写p2p的
	 * @param userid receiverid
	 * @param offLineTime 离线时间
	 * @return 判断size
	 * */
	public ArrayList<P2PMsg> getOffLineMsg(String userid,String offLineTime){
		ArrayList<P2PMsg> list_P2PMsg = new ArrayList<>();
		
		String sql = GET_OFF_LINE_MSG_PERSON;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, userid);
			psta.setString(2, offLineTime);
			
			rs = psta.executeQuery();
			while(rs.next()){
				P2PMsg info = new P2PMsg();
				info.setMessageid(rs.getString("MESSAGEID"));
				info.setContent(rs.getString("CONTENT"));
				info.setCreateTime(rs.getString("CREATEDATE"));
				info.setReceiver(rs.getString("RECEIVER"));
				info.setSender(rs.getString("SENDER"));
				
				list_P2PMsg.add(info);
			}
			
			return list_P2PMsg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list_P2PMsg;
		}finally{
			try {
				rs.close();
				psta.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		new OffLineMsgDAOImpl().getOffLineMsg("110@120.27.49.173", "2016-11-14 13:14:07");
	}
}
