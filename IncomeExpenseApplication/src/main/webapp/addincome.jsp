<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.inc.pojo.User"%>
<%@ page import="com.inc.dao.UserDao"%>
<%@ page import="com.inc.servlet.UserServlet"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<User> ulist = new UserDao().getUserList();
	User user = (User) session.getAttribute("user");
	%>

	<jsp:include page="sidbar.jsp"></jsp:include>
	<div id="main">
		<form action="IncomeServlet" method="post">
			 <input type="hidden" name="action" value="addIncome">
			 <input	type="hidden" name="userId" value="<%=user.getId()%>">

			<table cellspacing="10" Border="1">
				<tr>
					<td>Income</td>
					<td><input type="number" name="income" required="required">
					</td>
				</tr>

				<tr>
					<td>IncomeType</td>
					<td><select name="incomeType">
							<option>-----> Select <-----</option>
							<option>Salary</option>
							<option>Collection</option>
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
					<td><input type="text" value="<%=user.getEmail()%>"></td>
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