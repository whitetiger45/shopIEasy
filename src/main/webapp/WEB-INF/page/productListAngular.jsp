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
<title>Search Products</title>
<link rel="icon" type="image/x-icon"
	href="<c:url value="../resource/images/favicon1.png"/>" />
<link rel="stylesheet"
	href="<c:url value="../resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="../resource/js/jquery.js"/>"></script>
<script src="<c:url value="../resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="../resource/css/ProductList.css"/>">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="../resource/js/productController.js"/>"></script>
</head>
<body ng-app="myapp">
	<div>
		<div ng-controller="myController" ng-init="getProductList()">
			<div class="container" id="productTable"
				style="width: 1145px; margin-bottom: 180px;">
				<h2>Product Management</h2>
				<p>The List of Products in our Database</p>
				Search: <input type="text" ng-model="searchCondition"
					placeholder="Search Product">
				<table class="table table-hover" id="productList">
					<thead>
						<tr>
							<th>Screen-Shot</th>
							<th>Product Id</th>
							<th>Category</th>
							<th>Product Name</th>
							<th>Products Price</th>
							<th>Stock Unit</th>
							<th>Description</th>
							<th>Manufacturer</th>
							<th>View <security:authorize ifAnyGranted="ROLE_USER">
					/ Add to Cart
					</security:authorize> 
					<!-- views only to the admin -->
					<security:authorize	ifAnyGranted="ROLE_ADMIN">
					/Edit/Delete
					</security:authorize>
							</th>
						</tr>
					</thead>
					<tbody>

						<tr ng-repeat="b in products | filter:searchCondition">
							<td style="width: 171px">
								<img src="<c:url value="../resource/images/products/{{b.productId}}.jpg"/>"
								style="width: 100px; height: 90px;" {{b.productName}}"  /></td>
							<td>{{b.productId}}</td>
							<td>{{b.productCategory}}</td>
							<td>{{b.productName}}</td>
							<td>{{b.productPrice}}</td>
							<td>{{b.unitStock}}</td>
							<td style="width: 180px">{{b.productDescription}}</td>
							<td>{{b.productManufacturer}}</td>
							<td><a href="getProductById/{{b.productId}}"
								class="btn btn-info" role="button"> <span
									class="glyphicon glyphicon-info-sign"></span></a> 
								<!-- view only for user 
								<security:authorize ifAnyGranted="ROLE_USER">
									<a href="#" ng-click="addToCart(${b.productId})" class="btn btn-primary"
										style="margin-left: 5px"> <span
										class="glyphicon glyphicon-shopping-cart"></span></a>
								</security:authorize> 
								-->
								<!-- view only to the admin -->
								<security:authorize ifAnyGranted="ROLE_ADMIN">
									<a href="admin/product/editProduct/{{b.productId}}"
										class="btn btn-success" style="margin-left: 5px"> <span
										class="glyphicon glyphicon-edit"></span></a>
									<a href="admin/delete/{{b.productId}}" class="btn btn-danger"
										style="margin-left: 5px"> <span
										class="glyphicon glyphicon-trash"></span></a>
								</security:authorize>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>
<%@ include file="footer.jsp"%>