package com.hdu.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdu.jersey.dao.TagDAO;
import com.hdu.jersey.dao.impl.sql.TagSql;
import com.hdu.jersey.model.Tag;
import com.hdu.jersey.util.DBUtil;

/**
 * @author zhuxin
 *
 */
public class TagDAOImpl implements TagDAO{

	private static  DBUtil dbutil = DBUtil.getInstance();

	/**
	 * 成功返回1.失败返回0
	 * */
	@Override
	public int createTag(Tag tag) {
		String sql = TagSql.CREATE_TAG;
		System.out.println(sql);
		
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, tag.getTagName());
			psta.setString(2, tag.getTagid());
			
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
	 * 失败为null
	 * */
	@Override
	public Tag select(String tagid) {
		Tag tag = null;
		String sql = TagSql.SELECT_BY_ID;
		System.out.println(sql);
		Connection connection = dbutil.getConnection();
		PreparedStatement psta = null;
		ResultSet rs = null ;
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, tagid);
			
			rs = psta.executeQuery();
			if(rs.next()){
				tag = new Tag();
				tag.setTagid(tagid);
				tag.setTagName(rs.getString("tagName"));
			}
			
			return tag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tag;
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
	

}
