<%@page import="com.inc.pojo.Income"%>
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
	Income inc = (Income) session.getAttribute("inc");
	%>

	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">
		<h1>Income Update Form</h1>
		<form action="IncomeServlet" method="post">
		     <input type="hidden" name="id" value="<%=inc.getId()%>">
			 <input type="hidden" name="action" value="updateIncome">
			 <input type="hidden" name="userId" value="<%=user.getId()%>">

			<table cellspacing="10" Border="1">
				<tr>
					<td>Income</td>
					<td><input type="number" name="income"
						value="<%=inc.getIncome()%>" required="required"></td>
				</tr>

				<tr>
					<td>IncomeType</td>
					<td><select name="incomeType" value="<%=inc.getIncome()%>">
							<option><%=inc.getIncomeType()%></option>
							<option>-----> Select <-----</option>
							<option>Salary</option>
							<option>Collection</option>
							<option>Others</option>
					</select></td>

				</tr>

				<tr>
					<td>Description</td>
					<td><textarea rows="3" cols="20" name="description"><%=inc.getDescription()%></textarea>
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