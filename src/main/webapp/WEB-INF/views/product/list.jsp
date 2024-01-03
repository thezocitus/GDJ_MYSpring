<%@page import="java.util.List"%>
<%@page import="com.winter.app.products.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%
 System.out.println("LIST");
%>
<!DOCTYPE html>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
<html>
<head>
<c:import url="../temps/header.jsp"></c:import>
<meta charset="UTF-8">
<title>Product</title>

</head>
<body>
	<table class="table table-success table-striped">
		<thead>
			<tr>
				<td>PRODUCT_NUM</td>
				<td>PRODUCT_NAME</td>
				<td>PRODUCT_CONTENTS</td>
				<td>PRODUCT_RATE</td>
				<td>PRODUCT_JUMSU</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
				 	<td>${pageScope.dto.productNum}</td>
				 	<td><a href="./detail?productNum=${pageScope.dto.productNum}">${pageScope.dto.productName}</a></td>
				 	<td>${pageScope.dto.productContents}</td>
				 	<td>${pageScope.dto.productRate}</td>
				 	<td>${pageScope.dto.productJumsu}</td>
			</c:forEach>
			
		</tbody>
	</table>
	
	
	
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>