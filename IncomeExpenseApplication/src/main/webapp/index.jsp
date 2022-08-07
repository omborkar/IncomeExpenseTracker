<%@page import="com.inc.dao.IncomeDao"%>
<%@page import="com.inc.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	User user = (User) session.getAttribute("user");
	%>
	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">
		<h1>Income Expense Web Applications</h1>
		<%
		if (user != null) {
			double bal = new IncomeDao().getBalance(user.getId());
		%>
		<h2>
			WELCOME : <span style="color: green"> <%=user.getEmail()%></span>
		</h2>
		<h2>
			Your Balance is : <span style="color: green"><%=bal%></span>
		</h2>
		<%
		}
		%>
	</div>
</body>
</html>