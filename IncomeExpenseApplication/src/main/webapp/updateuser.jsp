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

<jsp:include page="sidbar.jsp"></jsp:include>

	<div id="main">

<%User u=(User)session.getAttribute("user"); %>

		<form action="UserServlet" method="post">
		<input type="hidden" name="action" value="updateuser">
			<table cellspacing="10" Border="1">

				<tr>
					<td>Id</td>
					<td><input type="text" name="id" value="<%=u.getId() %>" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=u.getName() %>" required="required">
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" value="<%=u.getEmail()%>" required="required">
					</td>
				</tr>

				<tr>
					<td>Contact</td>
					<td><input type="text" name="contact" value="<%=u.getContact()%>" required="required">
					</td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="passw1" value="<%=u.getPassword()%>" required="required">
					</td>
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