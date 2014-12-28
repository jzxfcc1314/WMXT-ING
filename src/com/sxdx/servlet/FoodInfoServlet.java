package com.sxdx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxdx.dao.FoodInfoDAO;
import com.sxdx.dao.FoodOrderInfoDAO;
import com.sxdx.dao.UserInfoDAO;
import com.sxdx.vo.FoodInfo;
import com.sxdx.vo.FoodOrderInfo;
import com.sxdx.vo.UserInfo;
/*
 * server corresponds to foodinfo
 */
public class FoodInfoServlet extends HttpServlet {
	public FoodInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("#FoodInfoServlet(FoodInfoServlet.java)");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//get op from previous page
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		String op=request.getParameter("op");
		//get current user from session hs
		HttpSession hs=request.getSession();
		Integer user=(Integer)hs.getAttribute("usr"); 
		
		if(op.equals("commit"))//process order
		{
			String customerName=request.getParameter("customerName");
			String address=request.getParameter("address");
			String telephone=request.getParameter("telephone");
			String allFoodInfo=request.getParameter("allFoodInfo");
			String worldLeft=request.getParameter("worldLeft");
			String state="订单已提交";
			double totalPrice=Double.parseDouble(request.getParameter("totalPrice"));
			FoodOrderInfo foodOrderinfo=new FoodOrderInfo(customerName, address, telephone, allFoodInfo, totalPrice, worldLeft, state);
			FoodOrderInfoDAO forDAO =new FoodOrderInfoDAO();
			if(forDAO.regUserInfo(foodOrderinfo))
			{
				request.getRequestDispatcher("/end.jsp").forward(request, response);
			}else
			{
				request.setAttribute("fail", "失败");
				request.getRequestDispatcher("/end.jsp").forward(request, response);
			}
		}
		if(op.equals("order"))//create order
		{
			//get userinfo
			UserInfo uinfo = new UserInfo();
			UserInfoDAO uinfoDAO = new UserInfoDAO();
			uinfo = uinfoDAO.GetUserInfo(user);
			//set temp attribute list1
			ArrayList<UserInfo> list1 = new ArrayList<UserInfo>();
			list1.add(uinfo);		
			hs.setAttribute("list1", list1);
			request.getRequestDispatcher("/endmoney.jsp").forward(request, response);
		}
		
		if(op.equals("login"))//show menu
		{
			
			ArrayList<FoodInfo> foodlist = foodDAO.selectAllFood();
			request.setAttribute("foodlist", foodlist);
			request.setAttribute("usr",user);
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
