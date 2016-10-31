package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hdu.jersey.dao.UserTagDAO;
import com.hdu.jersey.dao.impl.sql.UserTagInfoSql;
import com.hdu.jersey.model.UserTag;
import com.hdu.jersey.util.DBUtil;

public class UserTagDAOImpl implements UserTagDAO{

	private static DBUtil dbutil = DBUtil.getInstance();
	
	@Override
	/**
	 * 成功返回usertag
	 * 失败size为0
	 * */
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

}
