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
			ps=conn.prepareStatement("insert into foodOrderInfo "
					+ "(customerName,address,telephone,allFoodInfo,totalPrice,wordLeft,state) "
					+ "values(?,?,?,?,?,?,?)");
			ps.setString(1, foodOrderinfo.getCustomerName());
			ps.setString(2, foodOrderinfo.getAddress());
			ps.setString(3, foodOrderinfo.getTelephone());
			ps.setString(4, foodOrderinfo.getAllFoodInfo());
			ps.setDouble(5, foodOrderinfo.getTotalPrice());
			ps.setString(6, foodOrderinfo.getWordLeft());
			ps.setString(7, foodOrderinfo.getState());
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
