package com.sxdx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxdx.dao.UserInfoDAO;
/*
 * server manipulates login process
 */
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("#LoginServlet(LoginServlet.java)");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		//verify user
		UserInfoDAO userDAO=new UserInfoDAO();
		boolean flag=userDAO.checkLogin(username, userpass);
		
		if(flag)//login success
		{
			System.out.println("Login success");
			Integer user= userDAO.onlineUser(username, userpass);//get userid
			HttpSession hs=request.getSession();//create session hs 
			hs.setAttribute("usr",user);//add attribute user to the session with value userID
			request.getRequestDispatcher("/foodinfoservlet?op=login").forward(request, response);
		}else//lohin fail
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
