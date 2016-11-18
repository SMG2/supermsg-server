package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hdu.jersey.model.GroupLogResponse;
import com.hdu.jersey.model.GroupMessages;
import com.hdu.jersey.util.DBUtil;
import com.hdu.redis.jedis.RedisTool;

/**
 * @author F-zx
 * 群消息存储dao
 * */
 public class GroupMessageDAOImpl {
	 
	 private static SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
	 
	 private static DBUtil dbutil = DBUtil.getInstance();
	 //sql语句
	 private final static String INSERT_ROW = "insert into tb_group_log(groupid,userid,createtime,content) values(?,?,?,?)";
	 private final static String QUERY_OFFLINE_MSG_BY_GROUPID = "select messageid,userid,createtime,content from tb_group_log where groupid=? and createtime >= ?";
	 
	 
	 private ResultSet rs = null;
	 PreparedStatement psta = null;
	 
	 /**
	  * 添加一个groupmsg
	  * */
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
	 
	 public ArrayList<GroupLogResponse> getById(String userid,String groupid){
		 String offTime = RedisTool.getOffTimeByUserId(userid);
		 String sql = QUERY_OFFLINE_MSG_BY_GROUPID;
		 System.out.println(sql);
		 Connection connection = dbutil.getConnection();
		 ArrayList<GroupLogResponse> list = new ArrayList<>();
		 
		 try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, groupid);
			psta.setString(2, offTime);
			
			rs = psta.executeQuery();
			
			while(rs.next()){
				GroupLogResponse logResponse = new GroupLogResponse();
				logResponse.setContent(rs.getString("content"));
				logResponse.setMessageid(rs.getString("messageid"));
				logResponse.setCreatetime(rs.getString("createtime"));
				logResponse.setUserid(rs.getString("userid"));
				
				list.add(logResponse);
			}
			dbutil.closeConnection();
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}finally {
			if(psta != null)
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	 }
	 
	 
	 
	 
	 public static void main(String[] args) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
//		System.out.println(format.format(new Date()));
		 
		 ArrayList<GroupLogResponse> byId = new GroupMessageDAOImpl().getById("zhuxin", "14108414");
		 for (GroupLogResponse groupLogResponse : byId) {
			System.out.println(groupLogResponse.getMessageid());
		}
	}
}
