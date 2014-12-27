<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <body style="width:760px; height:700px; text-align: center;">

   <div style="width:760px; align="center">
	   <div style="height:141px;">
	   	<%@ include file="top.jsp" %>
	   </div>
	   <div id="centent" style="width:760px;height:100%; position:relative;">
		   <div style=" width:160px; height:240px; position:absolute; left:0px;top:0px; float:left;">
		   <%@ include file="left.jsp" %>
		   </div>
		   <div style="width:600px;height:111px;float:right;">
		   <%@ include file="right_top.jsp" %>
		   </div>
		   <div style="width:600px; height:240px;float:right;">
		   	<div style="height:20px; background-color:#AAB9BD">
		   	我学我会网上订餐系统用户请直接登录
		   	</div>
		   	<form action="/WMXT/loginservlet?op=login" method="post" style="height: 129px; width:300px; ">
		   		<br/>用户名：<input type="text" name="username" style="border:1px solid #666666; size: 17px;"  /><br/><br/>
		   		密&nbsp;&nbsp;码:&nbsp;&nbsp;&nbsp;<input type="password" name="userpass"  style="border:1px solid #666666;size: 17px;" /><br/><br/>
		   		<input type="submit" value="登录">
		   	</form>
		   </div>
	   </div>
	   <div>
	   <%@ include file="bottom.jsp" %>
	   </div>
   </div>
 
  </body>
</html>