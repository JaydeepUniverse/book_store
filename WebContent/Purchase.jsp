<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.Book_Details"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.BookSelect"%>

<%@ page import="java.sql.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store - Selected Books</title>

</head>
<table border="1" width="500">
	<tr>
		<th><b>Book ID</b></th>
		<th><b>Book Name</b></th>
		<th><b>Author</b></th>
		<th><b>Price</b></th>
		<th><b>Quantity</b>
	</tr>
	<%
	    ArrayList<Book_Details> bk = (ArrayList<Book_Details>)request.getAttribute("selected_books");
	    for (Book_Details s : bk) {
			int book_id = s.getId();
			String book_name = s.getBook_name();
			String book_author = s.getAuthor();
			int book_price = s.getPrice();
	%>
	<tr>
		<td><%=s.getId()%></td>
		<td><%=s.getBook_name()%></td>
		<td><%=s.getAuthor()%></td>
		<td><%=s.getPrice()%></td>
		<% System.out.println("1" + book_id); %>
		<td><form action="add_to_cart" method="post"><input type="number" name="quantity" />
		<input type="hidden" value=<%=s.getId()%> name="book_id" />
		<input id="add_to_cart" type="submit" value="Purchase"></form></td>
		<% System.out.println("2" + book_id); %>
	</tr>
	<%
	    }
	%>
</table>
</body>
</html>