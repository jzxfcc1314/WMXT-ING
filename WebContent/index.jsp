<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>index.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="width:760px; height:700px; text-align: center;">

   <div style="width:760px; align="center">
	   <div style="height:141px;">
	   	<%@ include file="top.jsp" %>
	   </div>  
	   <div id="centent" style="width:760px;height:100%; position:relative;">
	   <div style="background-image:url(images/background.jpg); width:800px; height:400px;float:left;">
		   <div style=" width:160px; height:240px; position:absolute; left:0px;top:0px; float:left;">
		   <%@ include file="left.jsp" %>
		   </div>
		   <div style="width:600px;height:111px;float:right;">
		   <%@ include file="right_top.jsp" %>
		   </div>
		   <div style="width:600px; height:240px;float:right;">
		   	<div style="height:20px; background-color:#AAB9BD">
		   	饱了么 网上订餐系统用户请直接登录
		   	</div>
		   	<form action="/WMXT/loginservlet" method="post" style="height: 129px; width:300px; ">
		   		<br/>用户名：<input type="text" name="username" style="border:1px solid #666666; size: 17px;"  /><br/><br/>
		   		密&nbsp;&nbsp;码：&nbsp;&nbsp;&nbsp;<input type="password" name="userpass"  style="border:1px solid #666666;size: 17px;" /><br/><br/>
		   		<input type="submit" value="登录">
		   	</form>
		   	<input type="button" value="注册" onclick="register()" />
		   	<script type="text/javascript">
				function register()
				{
					window.location="/WMXT/register.jsp?op=register}";
				}
			</script>
		   </div>
	   </div>
   </div>
 
  </body>
</html>
