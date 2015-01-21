<%@ page language="java" import="java.util.*,com.sxdx.vo.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>historyorder.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	table,tr,th,td{border:none;}
	th,td{width:100px;text-align:center;}
	</style>
	
  </head>
  
  <body style="width:760px; height:0px; text-align: center;">

    <div style="width:760px; height:0px; text-align:center; ">
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
		   	<div style="height:30px; background-color:#AAB9BD">
		   	<a href="" Style="display: block; width:90px; height:30px; float:right;"><img src="images/lcart_cn.gif" style="border:none;" /></a>
		   	</div>
		   	
		   	<div>
		   		<table >
		   		<tr style="background-color:#b6aeae;"><th>订单编号</th><th>订单内容</th><th>订单金额</th><th>订单状态</th></tr>
		   		
		   		<c:forEach var="order"  items="${requestScope.orderlist}"  >
		   		<tr>
		   		<td>${order.orderID }</td>
		   		<td>${order.allFoodInfo }</td>
		   		<td>${order.totalPrice }</td>
		   		<td>${order.state }</td>
		   		</tr>
		   		</c:forEach>
		   	
		   		</table>
		   		<div style="border:1px solid green; padding-top:20px; width:200px; height:50px;">
		   			<input type="button" value="返回个人信息" onclick="selfinfo()" />
		   			<script type="text/javascript">
						   function selfinfo()
						   {
						   	window.location="/WMXT/selfinfo.jsp";
						   }
					</script>
		   		</div>
		   	</div>
		   	
		   	
		   </div>
	   </div>
   </div>
  </body>
</html>
