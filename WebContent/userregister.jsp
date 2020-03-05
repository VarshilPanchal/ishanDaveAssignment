<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration Form</title>
</head>
<body>

	<a href="UserServlet?language=en_US">US</a>
	<a href="UserServlet?language=fr_FR">FR</a>
	<a href="UserServlet?language=in_IN">IN</a>

	
	<h1>${fform}</h1>
	<form action="./register" method="post">
		<table style="with: 50%">
			<tr>
				<td>${Message}</td>
			</tr>
			<tr>
				<td>${fusername}</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>${fpassword}</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<br> <input type="submit" value=${fsave} />
	</form>
</body>
</html>