package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hdu.jersey.dao.UserBaseInfoDAO;
import com.hdu.jersey.dao.impl.sql.UserBaseInfoSql;
import com.hdu.jersey.model.UserBaseInfo;
import com.hdu.jersey.util.DBUtil;

public class UserBaseInfoDAOImpl implements UserBaseInfoDAO{
	
	DBUtil dbutil = DBUtil.getInstance();
	
	@Override
	/**
	 * 返回1表示成功。0表示失败
	 * 
	 * */
	public int add(UserBaseInfo info) {
		String sql = UserBaseInfoSql.ADD_USER_BASEINFO;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		try {
			PreparedStatement psta = connection.prepareStatement(sql);
			psta.setString(1, info.getId());
			psta.setString(2, info.getSchool_num());
			psta.setString(3, info.getNation());
			psta.setString(4, info.getSt_num());
			psta.setString(5, info.getPwd());
			psta.setString(6, info.getSex());
			psta.setString(7, info.getName());
			
			return psta.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
//		finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return 0;
//			}
//		}
		
	}


	/**
	 * 返回1表示成功。0表示失败
	 * 
	 * */	
	@Override
	public int delete(String id) {
		String sql = UserBaseInfoSql.DELETE_USER_BASEINFO_BY_ID;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		try {
			PreparedStatement psta = connection.prepareStatement(sql);
			psta.setString(1, id);
			
			return psta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
	}

	@Override
	/**
	 * 返回1表示成功。0表示失败
	 * 
	 * */
	public int modify(UserBaseInfo info) {
		String sql = UserBaseInfoSql.ADD_USER_BASEINFO;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		try {
			PreparedStatement psta = connection.prepareStatement(sql);
			psta.setString(1, info.getId());
			psta.setString(2, info.getSchool_num());
			psta.setString(3, info.getNation());
			psta.setString(4, info.getSt_num());
			psta.setString(5, info.getPwd());
			psta.setString(6, info.getSex());
			psta.setString(7, info.getName());
			psta.setString(8, info.getId());
			
			return psta.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
//		finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return 0;
//			}
//		}
	}

	@Override
	public ArrayList<UserBaseInfo> listBaseInfo() {
		ArrayList<UserBaseInfo> list_userbaseinfo = new ArrayList<>();
		
		String sql = UserBaseInfoSql.SHOW_ALL_USERBASEINFO;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		Statement sta = null;
		ResultSet rs = null ;
		try {
			sta = connection.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()){
				UserBaseInfo baseInfo = new UserBaseInfo();
				baseInfo.setId(rs.getString("id"));
				baseInfo.setName(rs.getString("name"));
				baseInfo.setNation(rs.getString("nation"));
				baseInfo.setPwd("你猜");
				baseInfo.setSex(rs.getString("sex"));
				baseInfo.setSchool_num(rs.getString("school_num"));
				baseInfo.setSt_num(rs.getString("st_num"));
				
				list_userbaseinfo.add(baseInfo);
			}
			
			return list_userbaseinfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list_userbaseinfo;
		}finally{
			try {
				rs.close();
				sta.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 	若不存在就返回null
	 * 
	 * */
	@Override
	public UserBaseInfo showByid(String id) {
		String sql = UserBaseInfoSql.SHOW_USERBASEINFO;
		System.out.println(sql);
		
		UserBaseInfo baseInfo = null;
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, id);
			
			rs = psta.executeQuery();
			while(rs.next()){
				baseInfo = new UserBaseInfo();
				baseInfo.setId(rs.getString("id"));
				baseInfo.setName(rs.getString("name"));
				baseInfo.setNation(rs.getString("nation"));
				baseInfo.setPwd("这个不能说");
				baseInfo.setSex(rs.getString("sex"));
				baseInfo.setSchool_num(rs.getString("school_num"));
				baseInfo.setSt_num(rs.getString("st_num"));
			}
			
			return baseInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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

}
