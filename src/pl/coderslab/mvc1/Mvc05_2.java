package pl.coderslab.mvc1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.mvc.entities.Book;

@WebServlet("/Mvc05_2")
public class Mvc05_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/formMvc05_2.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		List<Book> bookslist;
		if (null == httpSession.getAttribute("booklist")) {
			bookslist = new ArrayList<>();
		} else {
			bookslist = (List<Book>) httpSession.getAttribute("booklist");
		}
		for (int i = 1; i <= 3; i++) {
			Book book = new Book();
			book.setAuthor(request.getParameter("author"+i));
			book.setTitle(request.getParameter("title"+i));
			book.setIsbn(request.getParameter("isbn"+i));
			bookslist.add(book);
		}
		
		httpSession.setAttribute("booklist",bookslist);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/resultMvc04.jsp").forward(request, response);

	}
	
	

}
