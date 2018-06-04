package pl.coderslab.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.jdbc.service.BookService;
import pl.coderslab.mvc.entities.Book;
@WebServlet("/search-book")
public class MvcJdbc04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	public MvcJdbc04() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		List<Book> books = bookService.bookByTitle(title);
		request.setAttribute("books", books);
		request.setAttribute("title", title);
		getServletContext().getRequestDispatcher("/WEB-INF/jdbc/jdbcAllBooks.jsp").forward(request, response);
	}

}
