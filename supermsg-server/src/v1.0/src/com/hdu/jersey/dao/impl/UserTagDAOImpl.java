package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hdu.jersey.dao.UserTagDAO;
import com.hdu.jersey.dao.impl.sql.UserTagInfoSql;
import com.hdu.jersey.model.Tag;
import com.hdu.jersey.model.UserTag;
import com.hdu.jersey.util.DBUtil;

public class UserTagDAOImpl implements UserTagDAO{

	private static DBUtil dbutil = DBUtil.getInstance();
	private static TagDAOImpl tagdao = new TagDAOImpl();
	
	/**
	 * 成功返回usertag
	 * 失败size为0
	 * */
	@Override
	public ArrayList<UserTag> getUsersByTagId(String tagid) {
		ArrayList<UserTag> list_usertag = new ArrayList<>();
		
		String sql = UserTagInfoSql.SELECT_USERS_BY_TAGID;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, tagid);
			
			rs = psta.executeQuery();
			while(rs.next()){
				UserTag userTag = new UserTag();
				userTag.setTagid(tagid);
				userTag.setUserid(rs.getString("id"));
				
				list_usertag.add(userTag);
			}
			
			return list_usertag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list_usertag;
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

	/**
	 * 成功返回tag
	 * 失败size为0
	 * */
	@Override
	public ArrayList<Tag> getTagsByUserid(String userid) {
		ArrayList<Tag> list_tags = new ArrayList<>();
		
		String sql = UserTagInfoSql.SELECT_TAGS_BY_USERID;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, userid);
			
			rs = psta.executeQuery();
			while(rs.next()){
				Tag tag = tagdao.select(rs.getString("tagid"));
				if(tag != null)
					list_tags.add(tag);
			}
			
			return list_tags;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list_tags;
		}finally{
			try {
				rs.close();
				psta.close();
//				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 失败为false
	 * */
	@Override
	public boolean addTagForUser(UserTag userTag) {
		String sql = UserTagInfoSql.INSERT_TAG_FOR_USER;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, userTag.getUserid());
			psta.setString(2, userTag.getTagid());
			
			int i = psta.executeUpdate();
			
			if(i == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				psta.close();
//				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 失败为0
	 * */
	@Override
	public int delete(UserTag userTag) {
		String sql = UserTagInfoSql.INSERT_TAG_FOR_USER;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, userTag.getUserid());
			psta.setString(2, userTag.getTagid());
			
			return psta.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			try {
				psta.close();
//				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
