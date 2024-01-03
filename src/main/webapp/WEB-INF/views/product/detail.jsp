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
<c:import url="../temps/header.jsp"></c:import>1`
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<h1>Product Detail</h1>
	<h3>${requestScope.DTO.productNum}</h3>
	<h3>${requestScope.DTO.productName}</h3>
	<h3>${requestScope.DTO.productContents}</h3>
	<h3>${requestScope.DTO.productRate}</h3>
	<h3>${requestScope.DTO.productJumsu}</h3>


	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>