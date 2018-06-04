package pl.coderslab.mvc1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.mvc.entities.Book;


@WebServlet("/Mvc04")
public class Mvc04 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/form.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> booklist = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Book book = new Book();
			book.setAuthor(request.getParameter("author"+i));
			book.setTitle(request.getParameter("title"+i));
			book.setIsbn(request.getParameter("isbn"+i));
			booklist.add(book);
		}
	
		request.setAttribute("booklist", booklist);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/resultMvc04.jsp").forward(request, response);
	}
}
// #### Zadanie 4
//
// W projekcie stwórz servlet `Mvc04`. Następnie:
// 1. W widoku wyświetlanym metodą `GET` o nazwie `form.jsp` stwórz formularz
// zawierający pola o nazwach (title1, author1, isbn1),
// (title2, author2, isbn2), itd do 5.
// Formularz ma być przesłany metodą POST do servletu `Mvc04`.
// 2. Zaimportuj wcześniej stworzoną klasę `Book`.
// 3. W servlecie `Mvc04` odbierz dane i na ich podstawie stwórz obiekty klasy
// Book.
// 4. Obiekty umieść w liście lub tablicy, którą następnie przekaż do widoku
// `result.jsp`.
// 5. W pętli wyświetl właściwości wszystkich obiektów `title`, `author`.
