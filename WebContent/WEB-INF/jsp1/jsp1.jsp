<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jsp1</title>
</head>
<body>
<%Date date =  new Date(); %>
<h1>Aktualna data to: <%out.print(date); %></h1>

</body>
</html>
<!-- #### Zadanie 1 - rozwiązywane z wykładowcą

W projekcie stwórz stronę `jsp1.jsp`. Następnie: 
1. W skryptlecie utwórz zmienną z aktualną datą i godziną i wyświetl ją na stronie.
2. Pamiętaj by dodać odpowiedni import. -->