package com.hdu.jersey.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 单例模式的dbutil
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
	 * 	初始化配置文件
	 * */
	private DBUtil(){
//		try {
//			properties.load(this.getClass().getClassLoader().getResource("conf/db.properties").openStream());
//		} catch (IOException e) {
//			System.out.println("配置文件加载失败");
//			e.printStackTrace();
//		}catch (Exception e) {
//			System.out.println("配置文件加载失败");
//			e.printStackTrace();
//		}
//		//设置参数
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
			System.out.println("配置文件加载失败");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//设置参数
		dbdriver = properties.getProperty("driver");
		dburl = properties.getProperty("url");
		username = properties.getProperty("userName");
		password = properties.getProperty("password");
		
		//创建连接
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
	 * 	获得dbutil的实例，
	 * 
	 * */
	public static DBUtil getInstance(){
		return instanceDbUtil;
	}
	
	
	/**
	 * 		蝴蝶一个数据库连接（无参数）
	 * 
	 * */
	public Connection getConnection(){
		if(connection==null)
			openConnection();
		return connection;
	}

	
	/**
	 * 		蝴蝶一个数据库连接（有参数）
	 * @param url 地址
	 * @param user 用户名
	 * @param pwd 密码
	 * 
	 * */
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

	
	
	
	/**
	 * 	关闭连接
	 * 
	 * */
	public void closeConnection(){
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 执行数据更新
	 * @param sql sql语句
	 * @return int 返回更新的行数
	 * 
	 * */
	public int executeUpdate(String sql){
		openConnection();
		try {
			PreparedStatement statement = getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			System.out.println("数据更新失败");
			e.printStackTrace();
		}
		return -1;
		
	}

	
	/**
	 * 		执行查询
	 * @param sql 要执行的sql语句
	 * 
	 * */
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
	
	
	/**
	 * 执行查询某条记录是否存在
	 * @param table 表
	 * @param column 列
	 * @param value 值
	 * @return 返回某一条记录是否存在(<b>true</b> or <b>false</b>)
	 * 
	 * */
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
