package com.sxdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sxdx.vo.FoodInfo;

public class FoodInfoDAO {
	public FoodInfo selectFoodById(int foodid)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		FoodInfo food=null;
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select * from foodInfo where foodID="+foodid+"");
			rs=ps.executeQuery();
			if(rs.next())
			{
				food=new FoodInfo();
				food.setFoodID(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodPrice(rs.getDouble(3));
				food.setIngredient(rs.getString(4));
				food.setDescription(rs.getString(5));
				food.setSoldNum(rs.getInt(6));
				food.setGoodNum(rs.getInt(7));
				food.setIsLeft(rs.getBoolean(8));
				food.setFoodImage(rs.getString(9));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return food;
	}

	public ArrayList<FoodInfo> selectAllFood()
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<FoodInfo> foodlist=new ArrayList<FoodInfo>();
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select * from foodinfo");
			rs=ps.executeQuery();
			while(rs.next())
			{
				FoodInfo food=new FoodInfo();
				food.setFoodID(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodPrice(rs.getDouble(3));
				food.setIngredient(rs.getString(4));
				food.setDescription(rs.getString(5));
				food.setSoldNum(rs.getInt(6));
				food.setGoodNum(rs.getInt(7));
				food.setIsLeft(rs.getBoolean(8));
				food.setFoodImage(rs.getString(9));
				foodlist.add(food);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return foodlist;
	}
}
