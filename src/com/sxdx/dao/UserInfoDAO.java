package com.sxdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfoDAO {
	//验证用户是否成功登录
	public boolean checkLogin(String username,String userpass)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select * from userinfo where loginname=? and loginpass=?");
			ps.setString(1, username);
			ps.setString(2, userpass);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return flag;
	}
	
	public boolean AddNewUser(String username,String userpass){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag = false;
		try
		{
			conn=BaseDAO.getConn();
			System.out.println("begin register");
			ps=conn.prepareStatement("insert into UserInfo values (?, ?, ?)");
			ps.setString(1, "3");
			ps.setString(2, username);
			ps.setString(3, userpass);
			//rs=ps.executeQuery();
			int sult=ps.executeUpdate();
			System.out.println(sult);
			if(sult>0)
			{
				flag=true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return flag;
	}
}
