package com.sxdx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxdx.dao.FoodInfoDAO;
import com.sxdx.dao.FoodOrderInfoDAO;
import com.sxdx.vo.FoodInfo;
import com.sxdx.vo.FoodOrderInfo;

public class FoodInfoServlet extends HttpServlet {
	public FoodInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		String op=request.getParameter("op");
		if(op.equals("reg"))
		{
			String customerName=request.getParameter("customerName");
			String address=request.getParameter("address");
			String telephone=request.getParameter("telephone");
			String allFoodInfo=request.getParameter("allFoodInfo");
			String worldLeft=request.getParameter("worldLeft");
			String state=request.getParameter("state");
			double totalPrice=Double.parseDouble(request.getParameter("totalPrice"));
			FoodOrderInfo foodOrderinfo=new FoodOrderInfo(customerName, address, telephone, allFoodInfo, totalPrice, worldLeft, state);
			FoodOrderInfoDAO forDAO =new FoodOrderInfoDAO();
			if(forDAO.regUserInfo(foodOrderinfo))
			{
				request.getRequestDispatcher("/end.jsp").forward(request, response);
			}else
			{
				request.setAttribute("fail", "Ê§°Ü");
				request.getRequestDispatcher("/end.jsp").forward(request, response);
			}
		}
		/*
		if(op.equals("details"))
		{
			int foodid = Integer.parseInt(request.getParameter("foodid"));
			FoodInfo food = foodDAO.selectFoodById(foodid);
			request.setAttribute("food", food);
			request.getRequestDispatcher("/fooddetails.jsp").forward(request, response);
		}
		*/
		if(op.equals("login"))
		{
			ArrayList<FoodInfo> foodlist = foodDAO.selectAllFood();
			request.setAttribute("foodlist", foodlist);
			request.getRequestDispatcher("/showfood.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
