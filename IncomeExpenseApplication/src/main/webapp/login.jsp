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

		<%
		String lmsg = (String) request.getAttribute("lmsg");
		if (lmsg != null) {
		%>

		<h1 style="color: red">
			<%=lmsg%></h1>

		<%
		}
		%>

		<form action="LoginServlet" method="post">
			<table cellspacing="10" Border="1">
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required="required">
					</td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="passw" required="required">
					</td>
				</tr>

				<tr>
					<td align="center"><input type="Submit" value="login"></td>
					<td align="center"><a href="adduser.jsp">click here to Register</a></td>

				</tr>
			</table>
		</form>
	</div>

</body>
</html>