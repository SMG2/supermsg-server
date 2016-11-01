package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hdu.jersey.dao.UserDetailInfoDAO;
import com.hdu.jersey.dao.impl.sql.UserDetailInfoSql;
import com.hdu.jersey.model.UserDetailInfo;
import com.hdu.jersey.util.DBUtil;

public class UserDetailInfoDAOImpl implements UserDetailInfoDAO{

	private static DBUtil dbutil = DBUtil.getInstance();
	
	/**
	 * 成功返回1失败反之
	 * 
	 * */
	@Override
	public int add(UserDetailInfo info) {
		String sql = UserDetailInfoSql.INSERT_USER_DETAIL;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		try {
			PreparedStatement psta = connection.prepareStatement(sql);
			psta.setString(1, info.getId());
			psta.setString(2, info.getCla());
			psta.setString(3, info.getCollege());
			psta.setString(4, info.getMajor());
			psta.setString(5, info.getGrade());
			psta.setString(6, info.getPhone());
			
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
	@Deprecated
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Deprecated
	public int modify() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<UserDetailInfo> listDetailInfo() {
		ArrayList<UserDetailInfo> list = new ArrayList<>();
		String sql = UserDetailInfoSql.SELECT_ALL;
		System.out.println(sql);
		
		Connection connection = dbutil.getConnection();
		Statement sta = null;
		ResultSet rs = null ;
		try {
			sta = connection.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()){
				UserDetailInfo detailInfo = new UserDetailInfo();
				detailInfo.setCla(rs.getString("class"));
				detailInfo.setCollege(rs.getString("college"));
				detailInfo.setGrade(rs.getString("grade"));
				detailInfo.setId(rs.getString("id"));
				detailInfo.setMajor(rs.getString("major"));
				detailInfo.setPhone(rs.getString("phone"));
				
				list.add(detailInfo);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
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
	 * 成功返回userdetail，失败为null
	 * */
	@Override
	public UserDetailInfo getDetail(String userid) {
		UserDetailInfo detailInfo = null;
		String sql = UserDetailInfoSql.SELECT_ALL;
		System.out.println(sql);
		
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, userid);
			rs = psta.executeQuery(sql);
			if(rs.next()){
				detailInfo = new UserDetailInfo();
				detailInfo.setCla(rs.getString("class"));
				detailInfo.setCollege(rs.getString("college"));
				detailInfo.setGrade(rs.getString("grade"));
				detailInfo.setId(rs.getString("id"));
				detailInfo.setMajor(rs.getString("major"));
				detailInfo.setPhone(rs.getString("phone"));
			}
			
			return detailInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return detailInfo;
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
