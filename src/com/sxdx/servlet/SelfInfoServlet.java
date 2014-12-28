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
 * server manages selfinfo
 */
public class SelfInfoServlet extends HttpServlet {
	public SelfInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("#SelfInfoServlet(SelfInfoServlet.java)");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//get userID;if not exists then back to index.jsp
		
		HttpSession hs=request.getSession();
		if(hs.getAttribute("usr")==null)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		Integer user=(Integer)hs.getAttribute("usr"); 
		String op=request.getParameter("op");
		if(op.equals("logout"))//if user applies logout
		{
			hs.invalidate();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}


		else if(op.equals("selfinfo"))//if user applies selfinfo
		{	
			//get userinfo
			UserInfo uinfo = new UserInfo();
			UserInfoDAO uinfoDAO = new UserInfoDAO();
			uinfo = uinfoDAO.GetUserInfo(user);
			//set temp attribute list
			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			list.add(uinfo);
			hs.setAttribute("list", list);
			request.getRequestDispatcher("/selfinfo.jsp").forward(request, response);
			
		}
		
		else if(op.equals("changeinfo"))//if user changes his info
		{	
			//get modified info
			String username=request.getParameter("loginName");
			String userpass=request.getParameter("loginPass");
			String address=request.getParameter("address");
			String telephone=request.getParameter("telephone");
			String photo=request.getParameter("photo");
			//update table UserInfo
			UserInfoDAO uinfoDAO=new UserInfoDAO();
			boolean flag = uinfoDAO.UpdateUser(user, username, userpass,address,telephone,photo);
			if (flag) //info change success
			{
				System.out.println("Change success");
				response.sendRedirect("/WMXT/selfinfoservlet?op=selfinfo" );
			}
			else  //info change fail or current updated
			{
				System.out.println("Change failed or Current updated");
				response.sendRedirect("/WMXT/selfinfoservlet?op=selfinfo");
			}
			
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
