package pl.coderslab.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.jdbc.service.BookService;

@WebServlet("/deleteBook")
public class MvcJdbc02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public MvcJdbc02() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg;
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			msg = bookService.deleteBook(id);
		} catch (Exception e) {
			msg = "<h1> Brak parametru id</h1>";
		}
		response.getWriter().append(msg);
	}

}
