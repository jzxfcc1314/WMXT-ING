package com.sxdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfoDAO {
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
	
	public boolean AddNewUser(String loginName,String loginPass,String address,String telephone,String photo){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag = false;
		try
		{
			conn=BaseDAO.getConn();
			System.out.println("begin register");
			ps=conn.prepareStatement("insert into UserInfo "
					+ "(loginName, loginPass, address, telephone, photo)"
					+ "values (?, ?, ?, ?, ?)");
			ps.setString(1, loginName);
			ps.setString(2, loginPass);
			ps.setString(3, address);
			ps.setString(4, telephone);
			ps.setString(5, photo);
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
