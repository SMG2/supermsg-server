package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			rs = psta.executeQuery();
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
	
	public List<String> getUseridsByclass(String groupid){
		List<String> list = new ArrayList<>();
		String sql = UserDetailInfoSql.QUERY_USERID_BY_CLASS;
		System.out.println(sql);
		
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, groupid);
			
			rs = psta.executeQuery();
			if(rs.next()){
				list.add(rs.getString("id"));
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
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
//		List<String> useridsByclass = new UserDetailInfoDAOImpl().getUseridsByclass("14108414");
//		for (String string : useridsByclass) {
//			System.out.println(string);
//		}
		
		System.out.println(new UserDetailInfoDAOImpl().getUserGroupByUserid("1033614108438"));
	}

	
	/**
	 * 获取用户所在的群组
	 * @param userid 用户id
	 * 
	 * @retrun 返回用户所在的class作为群组,若不存在用户信息，则返回""
	 * 
	 * */
	@Override
	public String getUserGroupByUserid(String userid) {

		String rel = "";
		String sql = UserDetailInfoSql.QUERY_USER_GROUP_BY_USERID;
		System.out.println(sql);
		
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, userid);
			
			rs = psta.executeQuery();
			if(rs.next()){
				rel = rs.getString("class");
			}
			
			return rel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return rel;
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
