package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hdu.jersey.dao.SchoolInfoDAO;
import com.hdu.jersey.dao.impl.sql.SchoolInfoSql;
import com.hdu.jersey.model.SchoolInfo;
import com.hdu.jersey.util.DBUtil;

public class SchoolInfoDAOImpl implements SchoolInfoDAO{

	private static DBUtil dbutil = DBUtil.getInstance();
	

	/**
	 * 返回1表示成功。0表示失败
	 * 
	 * */
	@Override
	public int add(SchoolInfo info) {
		String sql = SchoolInfoSql.INSERT_IN_TABLE;
		System.out.println(sql);
		
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, info.getSchool_num());
			psta.setString(2, info.getSchool_name());
			
			return psta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			
			try {
				psta.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
		
		
	}

	/**
	 * 返回1表示成功。0表示失败
	 * 
	 * */	
	@Override
	public int delete(String id) {
		String sql = SchoolInfoSql.DELETE_BY_SCHOOLNUM;
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

	/**
	 *  不想写 不必要的方法
	 * 
	 * */
	@Override
	@Deprecated
	public int modify() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SchoolInfo> listSchools() {
		ArrayList<SchoolInfo> list_SchoolInfo = new ArrayList<>();
		
		String sql = SchoolInfoSql.SELECT_ALL_SCHOOLS;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		Statement sta = null;
		ResultSet rs = null ;
		try {
			sta = connection.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()){
				SchoolInfo info = new SchoolInfo();
				info.setSchool_name(rs.getString("school_name"));
				info.setSchool_num(rs.getString("school_num"));
				
				list_SchoolInfo.add(info);
			}
			
			return list_SchoolInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list_SchoolInfo;
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
	 * 成功返回schoolInfo类实例，失败返回null
	 * 
	 * */
	@Override
	public SchoolInfo getInfoByNum(String school_num) {
		SchoolInfo info = null;
		
		String sql = SchoolInfoSql.SELECT_BY_NUM;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, school_num);
			
			rs = psta.executeQuery(sql);
			if(rs.next()){
				info = new SchoolInfo();
				info.setSchool_name(rs.getString("school_name"));
				info.setSchool_num(rs.getString("school_num"));
			}
			
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return info;
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
