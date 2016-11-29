<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Index</title>
	</head>
	<body>
		welcome to my index jsp page!!!<br><br>
		
		<a href="greeting">greeting</a><br><br>
		
		<a href="login.html">登录</a><br><br>
		
		<a href="register.html">注册</a><br><br>
		
		<a href="user.html">用户信息</a><br><br>
		
		<form action="user/queryByName" method="post">
			<input name="name" placeholder="name" type="text" required="required"/>
			<input type="submit" value="submit">
		</form>
	</body>
</html>