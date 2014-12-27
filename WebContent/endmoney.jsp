<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'endmoney.jsp' starting page</title>
    
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
  <% double moneys=Double.parseDouble(request.getParameter("total")) ; %>

    <div style="width:760px; height:600px;text-align:center; ">
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
		   	请确认配送和支付信息
		   	</div>
		   	<form action="/WMXT/foodinfoservlet?op=reg" method="post" style="border:1px solid red;">
		   		<table >
		   		<tr><td style="text-align:right;">订餐人：</td><td><input type="text" name="customerName"/></td></tr>
		   		<tr><td style="text-align:right;">送货地址：</td><td><input type="text" name="address"/></td></tr>
		   		<tr><td style="text-align:right;">邮政编码：</td><td><input type="text" name="zipCode"/></td></tr>
		   		<tr><td style="text-align:right;">联系电话：</td><td><input type="text" name="telephone"/></td></tr>
		   		<tr><td style="text-align:right;">移动电话：</td><td><input type="text" name="movePhone"/></td></tr>
		   		<tr><td style="text-align:right;">付款金额：</td><td ><input type="text" name="totalPrice" value="<%=moneys %>" />元</td></tr>
		   		<tr><td style="text-align:right;">配送方式：</td><td><input type="text" value="送餐上门" style="margin-left:10px;margin-right:20px;width:100px;"/><input style="width:100px;" type="text" value="10元起送"/></td></tr>
		   		<tr><td style="text-align:right;">支付方式：</td><td><input type="text" value="餐到付款" style="margin-left:10px;margin-right:20px;width:100px;"/><input style="width:100px;" type="text" value="仅限北京3环内"/></td></tr>
		   		<tr><td style="text-align:right;">订单附言：</td><td><textarea rows="5" cols="37"></textarea> </td></tr>
		   		
		   		</table>
		   		<input type="submit"value="确认以上信息无误，提交"/>
		   	</form>
		   </div>
	   </div>
	   <div>
	   <%@ include file="bottom.jsp" %>
	   </div>
   </div>

  </body>
</html>
