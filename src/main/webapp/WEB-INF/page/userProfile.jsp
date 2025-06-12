<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
<link rel="stylesheet" href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/register.css"/>">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<!-- will display after registration form registerd successfully -->
	<c:if test="${!empty updateSuccess}">
		<div class="error" style="color: #ff0000;">${updateSuccess}</div>
	</c:if>
	<h1 class="well"><center>Hello ${customer.getFirstName()}</center></h1>
	<!--<h1 class="well"><center>userId ${customer.getUsers().getUserId()}</center></h1>-->
	<br>
	<h2><center>User Details</center></h2>
	<br>
	<div class="container" style="margin-bottom: 19px">
		<div class="row">			
		<!--  UpdateUserServlet form -->
			<c:url value="/customer/updateUser" var="url"></c:url>
			<form:form method="post" action="${url}" commandName="customer"	enctype="multipart/form-data">
				<div class="row">
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="firstName">First Name</form:label>
							<form:input type="text" placeholder="${customer.getFirstName()}"
								class="form-control" path="firstName"></form:input>
							<form:errors path="firstName"></form:errors>
						</div>
						<div class="col-sm-6 form-group">
							<form:label path="lastName">Last Name</form:label>
							<form:input type="text" placeholder="${customer.getLastName()}"
								class="form-control" path="lastName"></form:input>
						</div>
					</div>
					<div class="row">
						<!--
						<div class="col-sm-6 form-group">
							<form:label path="users.emailId">Email Id</form:label>
							<form:input type="text" placeholder="${customer.getUsers().getEmailId()}"
								class="form-control" path="users.emailId"></form:input>
							<form:errors path="users.emailId"></form:errors>
						</div>
						-->
						<div class="col-sm-6 form-group">
							<form:label path="customerPhone">Phone Number</form:label>
							<form:input type="text" placeholder="${customer.getCustomerPhone()}"
								class="form-control" path="customerPhone"></form:input>
							<form:errors path="customerPhone"></form:errors>
						</div>
					</div>
					<div>
						<center>Shipping Address</center>
					</div>
					<div class="form-group">
						<form:label path="shippingAddress.address">Address</form:label>
						<form:textarea type="text" placeholder="${customer.getShippingAddress().getAddress()}"
							class="form-control" path="shippingAddress.address"></form:textarea>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="shippingAddress.city">City</form:label>
							<form:input type="text" placeholder="${customer.getShippingAddress().getCity()}"
								class="form-control" path="shippingAddress.city"></form:input>
						</div>
						<div class="col-sm-6 form-group">
							<form:label path="shippingAddress.state">State</form:label>
							<form:input type="text" placeholder="${customer.getShippingAddress().getState()}"
								class="form-control" path="shippingAddress.state"></form:input>
							<form:errors path="shippingAddress.state"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="shippingAddress.country">Country</form:label>
							<form:input type="text" placeholder="${customer.getShippingAddress().getCountry()}"
								class="form-control" path="shippingAddress.country"></form:input>
						</div>
						<div class="col-sm-6 form-group">
							<form:label path="shippingAddress.zipcode">Zipcode</form:label>
							<form:input type="text" placeholder="${customer.getShippingAddress().getZipcode()}"
								class="form-control" path="shippingAddress.zipcode"></form:input>
							<form:errors path="shippingAddress.zipcode"></form:errors>
						</div>
					</div>
					<div>
						<center>Billing Address</center>
					</div>
					<div class="form-group">
						<form:label path="billingAddress.address">Address</form:label>
						<form:textarea type="text" placeholder="${customer.getBillingAddress().getAddress()}"
							class="form-control" path="billingAddress.address"></form:textarea>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="billingAddress.city">City</form:label>
							<form:input type="text" placeholder="${customer.getBillingAddress().getCity()}"
								class="form-control" path="billingAddress.city"></form:input>
						</div>
						<div class="col-sm-6 form-group">
							<form:label path="billingAddress.state">State</form:label>
							<form:input type="text" placeholder="${customer.getBillingAddress().getState()}"
								class="form-control" path="billingAddress.state"></form:input>
							<form:errors path="billingAddress.state"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="billingAddress.country">Country</form:label>
							<form:input type="text" placeholder="${customer.getBillingAddress().getCountry()}"
								class="form-control" path="billingAddress.country"></form:input>
						</div>
						<div class="col-sm-6 form-group">
							<form:label path="billingAddress.zipcode">Zipcode</form:label>
							<form:input type="text" placeholder="${customer.getBillingAddress().getZipcode()}"
								class="form-control" path="billingAddress.zipcode"></form:input>
							<form:errors path="billingAddress.zipcode"></form:errors>
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-lg btn-info"
							onclick="return true">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>