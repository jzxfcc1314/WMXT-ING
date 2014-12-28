<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import = "com.sxdx.vo.UserInfo" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>endmoney.jsp</title>
    
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
  
  <body style="width:760px; height:700px; text-align: center;">
  <% HttpSession hs=request.getSession();%>
  <% Double moneys=(Double)hs.getAttribute("total"); %>
  <% String allFoodInfo=(String)hs.getAttribute("allFoodInfo");  %>
  <% ArrayList<UserInfo> list1=(ArrayList<UserInfo>)session.getAttribute("list1"); %>
  <% UserInfo uinfo=(UserInfo)list1.get(0); %>

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
		   	请填写并确认您的信息
		   	</div>
		   	<form action="/WMXT/foodinfoservlet?op=commit" method="post" style="border:1px solid red;">
		   		<table >
		   		<tr><td style="text-align:right;">订餐人：</td><td><input type="text" name="customerName" value="<%=uinfo.getLoginName() %>"/></td></tr>
		   		<tr><td style="text-align:right;">送餐地址：</td><td><input type="text" name="address" value="<%=uinfo.getAddress() %>"/></td></tr>
		   		<tr><td style="text-align:right;">联系电话：</td><td><input type="text" name="telephone" value="<%=uinfo.getTelephone() %>"/></td></tr>
		   		<tr><td style="text-align:right;">菜品信息：</td><td><input type="text" name="allFoodInfo" value="<%=allFoodInfo %>"/></td></tr>
		   		<tr><td style="text-align:right;">付款金额：</td><td><input type="text" name="totalPrice" value="<%=moneys %>" />元</td></tr>
		   		<tr><td style="text-align:right;">订单留言：</td><td><input type="text" name="wordLeft" value="<%="多加米" %>" /></td></tr>
		   		
		   		</table>
		   		<input type="submit"value="提交订单"/>
		   	</form>
		   	
		   	<input type="button" value="返回购物车" onclick="returnCart()" />
		   		<script type="text/javascript">
				function returnCart()
				{
					window.location="/WMXT/showcart.jsp";
				}
			</script>
		   </div>
	   </div>
   </div>

  </body>
</html>
