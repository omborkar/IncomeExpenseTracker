<%@page import="com.inc.dao.UserDao"%>
<%@page import="java.util.List"%>
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
	List<User> ulist = new UserDao().getUserList();
	User user=(User)session.getAttribute("user");
	String expmsg=(String)request.getAttribute("expmsg");
	%>

	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">
	
	<%if(expmsg!=null){ %>
	<h1 style="color:red"><%=expmsg %></h1>
	<%} %>
		<form action="ExpenseServlet" method="post">
		<input type="hidden" name="action" value="addExpense">
		<input type="hidden" name="userId" value="<%=user.getId()%>">
			<table cellspacing="10" Border="1">
				<tr>
					<td>Expense</td>
					<td><input type="number" name="expense" required="required">
					</td>
				</tr>

				<tr>
					<td>ExpenseType</td>
					<td><select name="expenseType">
							<option>-----> Select <-----</option>
							<option>Home</option>
							<option>Self</option>
							<option>Family</option>
							<option>Others</option>
					</select></td>

				</tr>

				<tr>
					<td>Description</td>
					<td><textarea rows="3" cols="20" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td>userName</td>
					<td><input type="text"  value="<%=user.getEmail() %>"></td>
				</tr>

				<tr>
					<td align="center"><input type="Submit" value="save"></td>
					<td align="center"><input type="reset" value="Reset"></td>

				</tr>
			</table>
		</form>
	</div>

</body>
</html>