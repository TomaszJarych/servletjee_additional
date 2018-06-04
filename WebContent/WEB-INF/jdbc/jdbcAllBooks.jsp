<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="pl.coderslab.mvc.entities.Book, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All books</title>
</head>
<body>
	<%
		List<Book> books = (List<Book>) request.getAttribute("books");
	%>
	<table border=1>
		<thead>
			<tr>
				<td>id</td>
				<td>Title</td>
				<td>Author</td>
				<td>ISBN</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="<%=books%>" var="book">
				<tr>
					<%
						String editUrl = "./MvcJdbc03Edit?id=";
					%>
					<%
						String deleteUrl = "./deleteBook?id=";
					%>
					<td>${book.getId()}</td>
					<td>${book.getAuthor() }</td>
					<td>${book.getTitle() }</td>
					<td>${book.getIsbn() }</td>
					<td><a href="<%out.print(editUrl);%>${book.getId()}">Edytuj</a>
						<a href="<%out.print(deleteUrl);%>${book.getId()}">Usuń</a></td>
				</tr>

			</c:forEach>

		</tbody>
		</table>
		<form action="./search-book">
		<label>
		<input name="title" value="<% out.print(request.getAttribute("title") != null ? request.getAttribute("title") : ""); %>"/> 
		</label>
		<input type="submit" value="Szukaj...">
	</form>
</body>
</html>