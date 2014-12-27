package com.sxdx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxdx.dao.UserInfoDAO;

public class RegisterServlet extends HttpServlet{
	
	public RegisterServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RegisterServlet");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		UserInfoDAO userDAO=new UserInfoDAO();
		System.out.println(username);
		System.out.println(userpass);
		boolean flag = userDAO.AddNewUser(username, userpass);
		if (flag) {
			System.out.println("Register success");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			System.out.println("Register failed");
			response.sendRedirect("/WMXT/index.jsp");
		}
		/*
		String op=request.getParameter("op");
		if(op.equals("register")) {
			request.getRequestDispatcher("/loginservlet").forward(request, response);
		}
		*/
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
