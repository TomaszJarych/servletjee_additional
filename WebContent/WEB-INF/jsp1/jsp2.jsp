<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP2</title>
</head>
<body>
<%! Date now =  new Date();%>
<h1>Data w deklaracji <%out.print(now); %></h1>
<h1>Data w skryplecie <% out.print(new Date());%></h1>

</body>
</html>
<!-- #### Zadanie 2 - rozwiązywane z wykładowcą

W pliku `jsp2.jsp`:
1. W deklaracji utwórz zmienną z aktualną datą i godziną i wyświetl ją na stronie.
2. Zaobserwuj różnicę odświeżając stronę kilka razy. -->