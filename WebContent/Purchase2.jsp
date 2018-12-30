<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.Book_Details"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.BookSelect"%>
<%@page import="com.AddToCart"%>

<%@ page import="java.sql.*"%>

<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#customer_name').click(function() {
			$("#orderMessage").hide();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store - Order Confirmation</title>

</head>
<body>
	<%
	    String order_details1 = (String) request.getAttribute("order_details");
	    String order_details = order_details1;
	%>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/project" user="root"
		password="devops" />
	<sql:query dataSource="${snapshot}" var="result" sql="${order_details}">
	</sql:query>
	<table border="1" width="500">
		<tr>
			<th><b>Order ID</b></th>
			<th><b>Book ID</b></th>
			<th><b>Customer Name</b></th>
			<th><b>Mobile No</b></th>
			<th><b>Address</b>
			<th><b>Order Date and Time</b>
			<th><b>Quantity</b>
		</tr>
		<c:forEach var="user" items="${result.rows}">
			<tr>

				<td><c:out value="${user.order_id}" /></td>
				<td><c:out value="${user.book_id}" /></td>
				<td><c:out value="${user.customer_name}" /></td>
				<td><c:out value="${user.phone_no}" /></td>
				<td><c:out value="${user.address}" /></td>
				<td><c:out value="${user.order_date}" /></td>
				<td><c:out value="${user.quantity}" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<button  onclick="location.href = 'Confirm.html';" id="myButton" class="float-left submit-button">Confirm</button>
			</td>


		</tr>
	</table>
</body>
</html>