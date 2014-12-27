package com.sxdx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxdx.dao.UserInfoDAO;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LoginServlet");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		UserInfoDAO userDAO=new UserInfoDAO();
		boolean flag=userDAO.checkLogin(username, userpass);
		if(flag)
		{
			System.out.println("Login success");
			request.getRequestDispatcher("/foodinfoservlet").forward(request, response);
		}else
		{
			System.out.println("Login failed");
			response.sendRedirect("/WMXT/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
