package com.sxdx.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxdx.dao.FoodInfoDAO;
import com.sxdx.vo.FoodInfo;
import com.sxdx.vo.Item;
/*
 * server manipulates on cart
 */
public class AddCarServlet extends HttpServlet {
	public AddCarServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("#AddCarServlet(AddCarServlet.java)");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//get current user from session hs
		HttpSession hs=request.getSession();
		Integer user=(Integer)hs.getAttribute("usr"); 
		//create new attribute cart and add it to session hs
		HashMap map=(HashMap)hs.getAttribute("cart");

		int foodid=Integer.parseInt(request.getParameter("foodid"));
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		//manipulate cart
		if(map==null)//if cart is empty
		{
			map=new HashMap();
			FoodInfo food=foodDAO.selectFoodById(foodid);
			Item item=new Item();
			item.setFoodInfo(food);
			item.setCount(new Integer(1));
			map.put(foodid, item);
			hs.setAttribute("cart", map);
		}else
		{
			if(map.containsKey(foodid))//if food exists in cart,then add count
			{	
				Item item=(Item)map.get(foodid);
				item.setCount(item.getCount()+1);
				map.put(foodid, item);
				hs.setAttribute("cart", map);
			}else //if food not exists in cart,then add food with count 1
			{		
				FoodInfo food=foodDAO.selectFoodById(foodid);
				Item item=new Item();
				item.setFoodInfo(food);
				item.setCount(1);
				map.put(foodid, item);
				hs.setAttribute("cart", map);
			}
		}
		request.getRequestDispatcher("/foodinfoservlet?op=login").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
