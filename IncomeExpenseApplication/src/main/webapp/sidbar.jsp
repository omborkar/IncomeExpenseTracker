<%@page import="com.inc.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/app.css" rel="Stylesheet">
</head>
<body>

	<%
	User user = (User) session.getAttribute("user");
	%>

	<div id="sidbar">

		<h2>
			<a href="index.jsp">Home</a>
		</h2>

		<%
		if (user != null) {
		%>

		<h2>
			<a href="addincome.jsp">AddIncome</a>
		</h2>
		<h2>
			<a href="addexpense.jsp">AddExpense</a>
		</h2>
		<h2>
			<a href="IncomeServlet">IncomeList</a>
		</h2>
		<h2>
			<a href="ExpenseServlet">ExpenseList</a>
		</h2>
		<h2>
			<a href="LoginServlet">Logout</a>
		</h2>
		<h2>
			<a href="updateuser.jsp">EditProfile</a>
		</h2>

		<%
		}
		if (user == null) {
		%>

		<h2>
			<a href="adduser.jsp">Register</a>
		</h2>

		<h2>
			<a href="login.jsp">Login</a>
		</h2>

		<%
		}
		%>


		<h2>
			<a href="aboutus.jsp">About-us</a>
		</h2>
	</div>

</body>
</html>