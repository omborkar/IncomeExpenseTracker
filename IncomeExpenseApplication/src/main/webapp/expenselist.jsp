<%@page import="com.inc.pojo.Expense"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#rside {
	width: 230px;
	height: 100%;
	background: aqua;
	position: fixed;
	top: 0%;
	right: 0%;
}
</style>
</head>
<body>

	<%
		List<Expense> expl = (List<Expense>) session.getAttribute("explist");
		int count = 1;
		%>
	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">

		<br>
		<form action="ExpenseServlet?action=srch" method="post">
			<textarea rows="3" cols="70" name="search"></textarea>
			<input type="submit" value="Search">
		</form>



		<table border="1" cellspacing="10">
			<tr>
				<th>ID</th>
				<th>EXPENSE</th>
				<th>EXPENSE TYPE</th>
				<th>EXPENSE DATE</th>
				<th>DESCRIPTION</th>

				<th>ACTION</th>
			</tr>
			<%
			for (Expense i : expl) {
			%>
			<tr>
				<td><%=count++%></td>
				<td><%=i.getExpense()%></td>
				<td><%=i.getExpenseType()%></td>
				<td><%=i.getExpenseDate()%></td>
				<td><%=i.getDescription()%></td>
				<td><a href="ExpenseServlet?action=delete&id=<%=i.getId()%>">Delete</a></td>
				<td><a href="ExpenseServlet?action=edit&id=<%=i.getId()%>">Edit</a></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
	
		<div id="rside">
		<h2>By Expense Type</h2>
		<ol>
		<li>
				<h4>
					<a href="ExpenseServlet">All</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="ExpenseServlet?action=searchByExpType&type=home">Home</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="ExpenseServlet?action=searchByExpType&type=self">Self</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="ExpenseServlet?action=searchByExpType&type=family">Family</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="ExpenseServlet?action=searchByExpType&type=others">Others</a>
				</h4>
			</li>
		</ol>
	</div>
</body>
</html>