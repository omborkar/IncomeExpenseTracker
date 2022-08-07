<%@page import="com.inc.pojo.Income"%>
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
	List<Income> incl = (List<Income>) session.getAttribute("inclist");
	int count = 1;
	%>
	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">
		<br>
		<form action="IncomeServlet?action=srch" method="post">
			<textarea rows="3" cols="70" name="search"></textarea>
			<input type="submit" value="Search">
		</form>
		<table border="1" cellspacing="10">
			<tr>
				<th>ID</th>
				<th>INCOME</th>
				<th>INCOME TYPE</th>
				<th>INCOME DATE</th>
				<th>DESCRIPTION</th>

				<th colspan="2">ACTION</th>
			</tr>
			<%
			for (Income i : incl) {
			%>
			<tr>
				<td><%=count++%></td>
				<td><%=i.getIncome()%></td>
				<td><%=i.getIncomeType()%></td>
				<td><%=i.getIncomeDate()%></td>
				<td><%=i.getDescription()%></td>
				<td><a href="IncomeServlet?action=delete&id=<%=i.getId()%>">Delete</a></td>
				<td><a href="IncomeServlet?action=edit&id=<%=i.getId()%>">Edit</a></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>


	<div id="rside">
		<h2>By Income Type</h2>
		<ol>
			<li>
				<h4>
					<a href="IncomeServlet">All</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="IncomeServlet?action=searchByIncType&type=salary">Salary</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="IncomeServlet?action=searchByIncType&type=collection">Collection</a>
				</h4>
			</li>
			<li>
				<h4>
					<a href="IncomeServlet?action=searchByIncType&type=others">Others</a>
				</h4>
			</li>
		</ol>
	</div>

</body>
</html>