<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP3</title>
</head>
<body>

	<%
	int aNum = Integer.parseInt(request.getParameter("a"));
	int bNum = Integer.parseInt(request.getParameter("b"));
	for (int i = aNum; i <= bNum; i++){%>
	<h1><%= i  %></h1>
	<% } %>

</body>
</html>
<!-- #### Zadanie 3
W projekcie stwórz stronę `jsp3.jsp`. Następnie: 
1. W skryptlecie pobierz z GET wartości `a` i `b`, a następnie wyświetl od `a` do `b`,
 umieszczając je w tagach html w następujący sposób:    
    ````html
    <ul>
      <li>1</li>
      <li>2</li>
      <li>3</li>
      ....
    </ul>
    ````
2. Zakładamy, że `a` i `b` są wartościami całkowitymi liczbowymi i `a < b`.
 -->