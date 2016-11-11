package com.hdu.openfire.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 
 * */
public class DBUtil {
	
	private static DBUtil instanceDbUtil = new DBUtil();
	
	private Properties properties = new Properties();
	private static  String dbdriver;
	private static  String dburl;
	private static  String username;
	private static  String password;
	
	private Connection connection;
	
	/**
	 * 
	 * */
	private DBUtil(){
//		try {
//			properties.load(this.getClass().getClassLoader().getResource("conf/db.properties").openStream());
//		} catch (IOException e) {
//			System.out.println("�����ļ�����ʧ��");
//			e.printStackTrace();
//		}catch (Exception e) {
//			System.out.println("�����ļ�����ʧ��");
//			e.printStackTrace();
//		}
//		//���ò���
//		dbdriver = properties.getProperty("driver");
//		dburl = properties.getProperty("url");
//		username = properties.getProperty("userName");
//		password = properties.getProperty("password");
//		System.out.println(dbdriver);
	}
	
	
	public void openConnection(){
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("conf/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//���ò���
		dbdriver = properties.getProperty("driver");
		dburl = properties.getProperty("url");
		username = properties.getProperty("userName");
		password = properties.getProperty("password");
		
		//��������
		try {
			Class.forName(dbdriver)
			.newInstance();
			connection = DriverManager.getConnection(dburl, username, password);
			System.out.println("connect to " +connection.getCatalog());
		} catch (Exception e) {
			System.out.println("fail to connect to ...");
			e.printStackTrace();
		}
	}
	
	/**
	 * 	
	 * 
	 * */
	public static DBUtil getInstance(){
		return instanceDbUtil;
	}
	
	
	/**
	 * 
	 * 
	 * */
	public Connection getConnection(){
		try {
			if(connection==null||connection.isClosed())
				openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	

	public Connection getConnection(String url,String user,String pwd){
		try {
			Class.forName(dbdriver).newInstance();
			connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("connect to " +connection.getCatalog());
		} catch (Exception e) {
			System.out.println("fail to connect to ...");
			e.printStackTrace();
		}
		return connection;
	}

	

	public void closeConnection(){
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	public int executeUpdate(String sql){
		openConnection();
		try {
			PreparedStatement statement = getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			System.out.println("���ݸ���ʧ��");
			e.printStackTrace();
		}
		return -1;
		
	}


	public ResultSet executeQuery(String sql){
		openConnection();
	    try {	
	      Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	      ResultSet rs = statement.executeQuery(sql);
	      return rs;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	
	    return null;	
	}
	
	

	public boolean isExit(String table, String column, String value){
		
		openConnection();
	    String sql = "select * from " +  table + " where " + column + " like '" + value + "'";
	    ResultSet rs = this.executeQuery(sql);
	    boolean flag = false;
	    try {
	      while (rs.next()) {
	        flag = true;
	        break;
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return flag;
	  }

	

	
	
	public static void main(String[] args) throws SQLException {
		System.out.println(DBUtil.getInstance().getConnection().getCatalog());
	}
}
