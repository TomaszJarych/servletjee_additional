package pl.coderslab.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/admin/*")
public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		if (null == session.getAttribute("username")) {
			res.sendRedirect(req.getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}
	}

}
//#### Zadanie 4
//
//1. Dodaj filtr o nazwie `AuthFilter`, który będzie miał mapowanie na wszystkie adresy z przedrostkiem `/admin/*`.
// Jeżeli w sesji nie ma klucza o nazwie `username`, przekieruj na stronę wyświetlającą formularz logowania.
//2. Umieść w deskryptorze wdrożenia `login` oraz `password`.
//3. Dodaj formularz logowania, zawierający pola `login` oraz `password`
//4. Dodaj servlet `LoginServlet`, w którym będzie się sprawdzanie poprawności podanych w formularzu danych. (możesz pominąć hashowanie hasła).
//5. Jeżeli dane są poprawne, zapisz nazwę użytkownika do sesji pod kluczem `username`.
//6. Dodaj servlet `Logout`, który będzie usuwał dane z sesji.
