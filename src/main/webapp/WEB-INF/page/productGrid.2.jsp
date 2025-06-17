<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!-- 	navigation Bar -->
<%@ include file="navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet"
			href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
		<script src="<c:url value="/resource/js/jquery.js"/>"></script>
		<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
		<style>
		body, h1, h2, h3, h4, h5 {
			font-family: "Raleway", sans-serif
		}
	
		.w3-sidenav a, .w3-sidenav h4 {
			font-weight: bold
		}
		</style>
	</head>
	<body ng-app="myapp">		
		<c:set var="i" value="0" />
		<c:set var="j" value="${products.size()}" />
		<c:forEach items="${products}" var="prod">
			<!-- <p>i: ${i} </p> -->
			<!-- <p>size of products: ${j} </p> -->
			<c:if test="${i % 3 == 0}">
				<hr>
				<div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
			</c:if>
			<div class="w3-third w3-container w3-margin-bottom">				
				<div class="w3-container w3-white">
					<a href="getProductById/${prod.productId}">
						<img src="<c:url value="/resource/images/products/${prod.productId}.jpg"/>" alt="Norway" style="width: 27%" class="w3-hover-opacity">
					</a>
					<p>
						<b>${prod.productName}</b>
					</p>
					<p>
						<ul>
							<li>${prod.productCategory}</li>
							<li>${prod.productManufacturer}</li>
							<li>${prod.productDescription}</li>
							<li>Price - ${prod.productPrice}</li>
							<li>Stock - ${prod.unitStock}</li>
						</ul>
					</p>
				</div>
			</div>
			<c:set var="i" scope="page" value="${i + 1}" />
			<c:if test="${i % 3 == 0}">
				</div>
			</c:if>
		</c:forEach>
		<c:if test="${j % 3 != 0}">
			</div>
		</c:if>
		<%@ include file="footer.jsp"%>
	</body>	
</html>
