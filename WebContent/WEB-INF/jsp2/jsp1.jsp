<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page errorPage="/WEB-INF/jsp2/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP2.1</title>
</head>
<body>
<%int[] array = {1,2,6}; %>
<h1><%= array[9] %></h1>
</body>
</html>