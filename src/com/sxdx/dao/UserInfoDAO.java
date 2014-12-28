package com.sxdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sxdx.vo.FoodInfo;
import com.sxdx.vo.UserInfo;
/*
 * interface to manupilate table "userinfo"
 */
public class UserInfoDAO {
	//verify the user
	public boolean checkLogin(String username,String userpass)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			System.out.println("#check login(UserInfoDAO.java)");
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
	//return current user's id
	public int onlineUser(String username,String userpass)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int flag = 0;
		try
		{
			System.out.println("#return userID(UserInfoDAO.java)");
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select * from userinfo where loginname=? and loginpass=?");
			ps.setString(1, username);
			ps.setString(2, userpass);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag = rs.getInt(1);
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
	
	//add new user
	public boolean AddNewUser(String loginName,String loginPass,String address,String telephone,String photo){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag = false;
		try
		{
			System.out.println("#add new user(UserInfoDAO.java)");
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("insert into UserInfo "
					+ "(loginName, loginPass, address, telephone, photo)"
					+ "values (?, ?, ?, ?, ?)");
			ps.setString(1, loginName);
			ps.setString(2, loginPass);
			ps.setString(3, address);
			ps.setString(4, telephone);
			ps.setString(5, photo);
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
	
	//update user information
	public boolean UpdateUser(int userID,String loginName,String loginPass,String address,String telephone,String photo){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag = false;
		try
		{
			conn=BaseDAO.getConn();
			System.out.println("#register(UserInfoDAO.java)");
			System.out.println(userID);
			System.out.println(address);
			System.out.println(telephone);
			ps=conn.prepareStatement("update UserInfo set loginName=?,loginPass=?,address=?,telephone=?,photo=? where userID="+userID+"");
			ps.setString(1, loginName);
			ps.setString(2, loginPass);
			ps.setString(3, address);
			ps.setString(4, telephone);
			ps.setString(5, photo);
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
	
	//get current user info
	public UserInfo GetUserInfo(int userid){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserInfo uinfo = null;
		try
		{
			conn=BaseDAO.getConn();
			System.out.println("#get userinfo(UserInfoDAO.java)");
			ps=conn.prepareStatement("select * from UserInfo where userID="+userid+"");
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				uinfo = new UserInfo();
				uinfo.setUserId(rs.getInt(1));
				uinfo.setLoginName(rs.getString(2));
				uinfo.setLoginPass(rs.getString(3));
				uinfo.setAddress(rs.getString(4));
				uinfo.setTelephone(rs.getString(5));
				uinfo.setPhoto(rs.getString(6));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return uinfo;
	}
		
}
