<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./MvcJdbc03Edit" method="post">
	<label>ID <input type="text" name="id" value="${book.getId() }"
		readonly>
</label>
	<label for="author">Autor </label>
	<input type="text" name="author" value="${book.getAuthor() }"
		id="author">
	<label for="title">Tytul</label>
	<input type="text" name="title" id="title" value="${book.getTitle() }">
	<label for="isbn">ISBN</label>
	<input type="text" name="isbn" id="isbn" value="${book.getIsbn() }">
	<input type="submit" value="Wyslij">
	</form>

</body>
</html>