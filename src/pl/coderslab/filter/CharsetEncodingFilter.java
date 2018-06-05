package pl.coderslab.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharsetEncodingFilter implements Filter {
	private static final String ENCODING = "UTF-8";
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);
		chain.doFilter(request, response);
	}


}
//#### Zadanie 1 - rozwiązywane z wykładowcą
//
//1. Utwórz filtr, który będzie ustawiał kodowanie dla obiektu żądania i odpowiedzi na `utf-8`.
