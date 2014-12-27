package com.sxdx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	public static Connection getConn()
	{
		Connection conn=null;
		try {
			System.out.println("BaseDAO");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/waimai","root","jizhixiang");
			System.out.println("Database connected");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
