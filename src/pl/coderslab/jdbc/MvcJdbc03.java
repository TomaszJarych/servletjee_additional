package pl.coderslab.jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.jdbc.service.BookService;
import pl.coderslab.mvc.entities.Book;

@WebServlet("/allBooks")
public class MvcJdbc03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public MvcJdbc03() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> books = new ArrayList<>();
		books = bookService.allBook();
		request.setAttribute("books", books);
		getServletContext().getRequestDispatcher("/WEB-INF/jdbc/jdbcAllBooks.jsp").forward(request, response);
	}

}
// #### Zadanie 3
//
// W projekcie stwórz servlety umożliwiające:
// 1. Wyświetlanie listy książek, dostępny pod adresem `/all-books`.
// 2. Edycję książki - link do edycji w tabeli html dla każdej książki.
//
// Dodaj linki umożliwiające usuwanie książek - link do usunięcia w tabeli html
// dla każdej książki.
//
// Przykład interfejsu:
//
// | Title | Author | Isbn | Akcja
// | ----------------- |:----------------:|:------- ------:| ----------:|
// | Thinking in Java | Bruce Eckel | 9789814035750 | Usuń Edytuj|
// | Java 2 Podstawy | Cay S. Horstmann | 9788371979842 | Usuń Edytuj|
