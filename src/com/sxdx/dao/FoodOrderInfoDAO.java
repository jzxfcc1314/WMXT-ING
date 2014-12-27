package com.sxdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sxdx.vo.FoodOrderInfo;

public class FoodOrderInfoDAO {
	//ÌîÐ´¶©²ÍÐÅÏ¢
	public boolean regUserInfo(FoodOrderInfo foodOrderinfo)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		boolean flag=false;
		try
		{
			conn=BaseDAO.getConn();
			System.out.println("begin insert into order");
			ps=conn.prepareStatement("insert into foodOrderInfo values(?,?,?,?,?,?,?,?)");
			ps.setString(1, "0");
			ps.setString(2, foodOrderinfo.getCustomerName());
			ps.setString(3, foodOrderinfo.getAddress());
			ps.setString(4, foodOrderinfo.getZipCode());
			ps.setString(5, foodOrderinfo.getTelephone());
			ps.setString(6, foodOrderinfo.getMovePhone());
			ps.setString(7, foodOrderinfo.getNotice());
			ps.setDouble(8, foodOrderinfo.getTotalPrice());
			int sult=ps.executeUpdate();
			System.out.println(sult);
			if(sult>0)
			{
				System.out.println("insert into order success");
				flag=true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, null);
		}
		return flag;
	}
}
