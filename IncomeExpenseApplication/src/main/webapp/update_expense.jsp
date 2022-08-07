<%@page import="com.inc.pojo.Expense"%>
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
	User user =(User)session.getAttribute("user");
	Expense exp=(Expense)session.getAttribute("exp");
	%>
	

	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">
		<h1>Expense Update Form</h1>
		<form action="ExpenseServlet" method="post">
		     <input type="hidden" name="id" value="<%=exp.getId()%>">
			 <input type="hidden" name="action" value="updateExpense">
			 <input type="hidden" name="userId" value="<%=user.getId()%>">

			<table cellspacing="10" Border="1">
				<tr>
					<td>Expense</td>
					<td><input type="number" name="expense"
						value="<%=exp.getExpense()%>" required="required"></td>
				</tr>

				<tr>
					<td>ExpenseType</td>
					<td><select name="expenseType" value="<%=exp.getExpense()%>">
							<option><%=exp.getExpenseType()%></option>
							<option>-----> Select <-----</option>
							<option>Family</option>
							<option>self</option>
							<option>Others</option>
					</select></td>

				</tr>

				<tr>
					<td>Description</td>
					<td><textarea rows="3" cols="20" name="description"><%=exp.getDescription()%></textarea>
					</td>
				</tr>
				<tr>
					<td>userName</td>
					<td><input type="text" value="<%=user.getEmail()%>"></td>
				</tr>

				<tr>
					<td align="center"><input type="Submit" value="Update"></td>
					<td align="center"><input type="reset" value="Reset"></td>

				</tr>
			</table>
		</form>

	</div>


</body>
</html>