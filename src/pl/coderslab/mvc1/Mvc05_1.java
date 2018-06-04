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

@WebServlet("/Mvc05_1")
public class Mvc05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("url", "./Mvc05_1");
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/mvc03.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		List<Book> books;
		if (null == httpSession.getAttribute("booklist")) {
			books = new ArrayList<>();
		} else {
			books = (List<Book>) httpSession.getAttribute("booklist");
		}
		Book book = new Book();
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		book.setIsbn(request.getParameter("isbn"));
		books.add(book);
		httpSession.setAttribute("booklist", books);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/resultMvc04.jsp").forward(request, response);

	}
}

// #### Zadanie 5
//
// 1. W projekcie stwórz servlet `Mvc05_1`.
// 2. Servlet ma udostępniać możliwość dodawania nowej książki w sposób
// pojedynczy (obiekt `Book`), który następnie będzie zapisywany do sesji.
// 3. Następnie stwórz `Mvc05_2`, który będzie udostępniał możliwość tworzenia 3
// książek na raz -
// podobnie jak w poprzednim zadaniu, niezależnie od metody dodania książki ma
// ona zostać zapisana w sesji. Utworzone obiekty przechowuj w tablicy.
// 4. Na końcu stwórz Servlet, który będzie wyświetlał w widoku listę wszystkich
// utworzonych książek.
