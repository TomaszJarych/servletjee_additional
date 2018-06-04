package pl.coderslab.mvc1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Mvc02")
public class Mvc02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg ="";
		try {
			int start = Integer.parseInt(req.getParameter("start"))+10;
			int end = Integer.parseInt(req.getParameter("end"))+10; 
			for (int i = start; i <= end; i++) {
				msg +=  i+" <br>";
			}	
		} catch (Exception e) {
			msg = "Bledne wartosci";
		}
		req.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/mvc02.jsp").forward(req, resp);
	}
}
//#### Zadanie 2 - rozwiązywane z wykładowcą
//
//W projekcie stwórz servlet `Mvc02`, który wczyta dwie zmienne GET : ```start``` i ```end``` . Następnie: 
//1. W servlecie zwiększ obie wartości o wartość `10`, przekaż zwiększone zmienne do widoku JSP .
//2. W widoku wyświetl  wszystkie liczby  ```start``` do ```end```. 
