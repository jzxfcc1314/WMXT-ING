package com.sxdx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxdx.dao.UserInfoDAO;
/*
 * server manipulates register process
 */
public class RegisterServlet extends HttpServlet{
	
	public RegisterServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("#RegisterServlet(RegisterServlet.java)");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//get register info
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String address=request.getParameter("address");
		String telephone=request.getParameter("telephone");
		String photo=request.getParameter("photo");
		UserInfoDAO userDAO=new UserInfoDAO();
		//add new user
		boolean flag = userDAO.AddNewUser(username, userpass,address,telephone,photo);
		if (flag) //register success
		{
			System.out.println("Register success");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else  //register fail
		{
			System.out.println("Register failed");
			response.sendRedirect("/WMXT/register.jsp");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
