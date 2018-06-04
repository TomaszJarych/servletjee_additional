package pl.coderslab.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.jdbc.service.BookService;
import pl.coderslab.mvc.entities.Book;

@WebServlet("/MvcJdbc03Edit")
public class MvcJdbc03Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	public MvcJdbc03Edit() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = bookService.bookById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("book",book);
		getServletContext().getRequestDispatcher("/WEB-INF/jdbc/jdbcEditBook.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = new Book();
		book.setId(Long.parseLong(request.getParameter("id")));
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		book.setIsbn(request.getParameter("isbn"));
		String msg = bookService.updateBook(book);
		response.getWriter().append("<h1>"+msg+"</h1>");
	}

}
