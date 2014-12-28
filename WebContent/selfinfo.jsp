<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import = "com.sxdx.vo.UserInfo" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>selfinfo.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	td{border:1px solid #999999; text-align:left}
	td input{width:250px;}
	</style>
  </head>
  
  <body style="width:760px; height:0px; text-align: center;">

  <% ArrayList<UserInfo> list=(ArrayList<UserInfo>)session.getAttribute("list"); %>
  <% UserInfo uinfo=(UserInfo)list.get(0); %>
  <% System.out.println(uinfo.getLoginName()); %>

    <div style="width:760px; height:0px;text-align:center; ">
	   <div style="height:141px;">
	   	<%@ include file="top.jsp" %>
	   </div>
	   <div id="centent" style="width:760px;  position:relative;">
		   <div style=" width:160px; height:240px; position:absolute; left:0px;top:0px; float:left;">
		   <%@ include file="left.jsp" %>
		   </div>
		   <div style="width:600px;height:111px;float:right;">
		   <%@ include file="right_top.jsp" %>
		   </div>
		   <div style="width:600px; height:200px;float:right;">
		   	<div style="height:20px; background-color:#AAB9BD">
		   	您的个人信息
		   	</div>
		   	<form action="/WMXT/selfinfoservlet?op=changeinfo" method="post" style="border:1px solid red;">
		   		<table >
		   		<tr><td style="text-align:right;">用户ID：</td><td><input type="text" name="userId" value="<%=uinfo.getUserId() %>"/></td></tr>
		   		<tr><td style="text-align:right;">用户名：</td><td><input type="text" name="loginName" value="<%=uinfo.getLoginName() %>"/></td></tr>
		   		<tr><td style="text-align:right;">用户密码：</td><td><input type="text" name="loginPass" value="<%=uinfo.getLoginPass() %>"/></td></tr>
		   		<tr><td style="text-align:right;">用户地址：</td><td><input type="text" name="address" value="<%=uinfo.getAddress() %>"/></td></tr>
		   		<tr><td style="text-align:right;">用户电话：</td><td><input type="text" name="telephone" value="<%=uinfo.getTelephone() %>" /></td></tr>
		   		<tr><td style="text-align:right;">用户头像：</td><td><textarea rows="3" cols="photo"></textarea> </td></tr>
		   		
		   		</table>
		   		<input type="submit"value="确定更改"/>
		   	</form>
		   	
		   	<input type="button" value="返回菜单" onclick="returnFoodList()" />
		   		<script type="text/javascript">
				function returnFoodList()
				{
					window.location="/WMXT/foodinfoservlet?op=login";
				}
			</script>
		   </div>
	   </div>
   </div>

  </body>
</html>
