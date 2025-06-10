<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<h3>Hello: ${customer.getFirstName()}</h3>
	<ol>
		<ul> <b>First Name:</b> ${customer.getFirstName()} </ul>
		<ul> <b>Last Name:</b> ${customer.getLastName()} </ul>
		<ul> <b>Phone number:</b> ${customer.getCustomerPhone()} </ul>
		<ul> <b>Email:</b> ${customer.getUsers().getEmailId()} </ul>
	</ol>
	<h4>Shipping Address</h4>
	<ol>
		<ul> <b>Address</b> ${customer.getShippingAddress().getAddress()} </ul>
		<ul> <b>City</b> ${customer.getShippingAddress().getCity()} </ul>
		<ul> <b>State</b> ${customer.getShippingAddress().getState()} </ul>
		<ul> <b>Zip Code</b> ${customer.getShippingAddress().getZipcode()} </ul>
		<ul> <b>Country</b> ${customer.getShippingAddress().getCountry()} </ul>
	</ol>	
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>