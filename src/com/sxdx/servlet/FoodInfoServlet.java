package com.sxdx.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

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
import com.sxdx.vo.Item;
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
			Calendar ca = Calendar.getInstance();
			String customerName=request.getParameter("customerName");
			String address=request.getParameter("address");
			String telephone=request.getParameter("telephone");
			String allFoodInfo=request.getParameter("allFoodInfo");
			String worldLeft=request.getParameter("wordLeft");
			String dateinfo=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format((Date)ca.getTime());
			String state="订单已提交";
			double totalPrice=Double.parseDouble(request.getParameter("totalPrice"));
			FoodOrderInfo foodOrderinfo=new FoodOrderInfo(customerName, address, telephone, allFoodInfo, totalPrice, worldLeft, state);
			FoodOrderInfoDAO forDAO =new FoodOrderInfoDAO();
			FoodInfoDAO foodinfoDAO=new FoodInfoDAO();
			FoodInfo foodinfo = new FoodInfo();
			if(forDAO.regUserInfo(foodOrderinfo))
			{
				request.getRequestDispatcher("/end.jsp").forward(request, response);
				//modify the number of food sold
				
				HashMap map=(HashMap)hs.getAttribute("cart"); 
		   		if(map!=null){
		   			Set keys=map.keySet(); 
		   			Object[] kes = keys.toArray(); 
		   			for(int i=0;i<keys.size();i++)
			   		{
				   		Item item=(Item)map.get(kes[i]);
				   		foodinfo = foodinfoDAO.selectFoodById(item.getFoodInfo().getFoodID());
				   		foodinfoDAO.UpdateSoldnum(item.getFoodInfo().getFoodID(),item.getCount()+foodinfo.getSoldNum());
			   		}
  				} 
  					
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
		if(op.equals("add"))//add count in cart
		{
			int fid=Integer.parseInt(request.getParameter("foodID"));
			System.out.println("foodID "+fid);
			HashMap map=(HashMap)hs.getAttribute("cart"); 
			Item item=(Item)map.get(fid);
			item.setCount(item.getCount()+1);
			response.sendRedirect("/WMXT/showcart.jsp");

		}
		
		if(op.equals("reduce"))//reduce count in cart
		{
			int fid=Integer.parseInt(request.getParameter("foodID"));
			System.out.println("foodID "+fid);
			HashMap map=(HashMap)hs.getAttribute("cart"); 
			Item item=(Item)map.get(fid);
			if(item.getCount()>0)
				item.setCount(item.getCount()-1);
			response.sendRedirect("/WMXT/showcart.jsp");

		}
		
		if(op.equals("good"))//add goodnum of food
		{
			int fid=Integer.parseInt(request.getParameter("foodID"));
			System.out.println("foodID "+fid);
			FoodInfoDAO foodinfoDAO=new FoodInfoDAO();
			FoodInfo foodinfo = new FoodInfo();
			foodinfo = foodinfoDAO.selectFoodById(fid);
	   		foodinfoDAO.UpdateGoodnum(fid,foodinfo.getGoodNum()+1);
	   		response.sendRedirect("/WMXT/foodinfoservlet?op=login");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
