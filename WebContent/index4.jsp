<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>大家好</title>
	</head>
	<body>
		普通方式取出data：
		<h2><%= request.getAttribute("data")%></h2>
		EL表达式取出data：
		<h2>${data}</h2>
	</body>
</html>