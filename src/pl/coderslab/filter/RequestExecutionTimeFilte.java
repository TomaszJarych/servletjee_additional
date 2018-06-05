package pl.coderslab.filter;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import pl.coderslab.filter.entities.FilterInfo;
import pl.coderslab.filter.service.FilterInfoService;

@WebFilter("/*")
public class RequestExecutionTimeFilte implements Filter {
	private FilterInfoService filterInfoService;
	
	public RequestExecutionTimeFilte() {
		 filterInfoService = new FilterInfoService();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		long stop = System.currentTimeMillis();
		long exec = stop - start;
		HttpServletRequest req = (HttpServletRequest) request;
		FilterInfo info = createFilterInfo(req);
		info.setExecutionTime(exec);
		filterInfoService.insertFilterInfo(info);
		System.out.println(req.getHeader("User-Agent"));
		System.out.println("Execution time: " + exec + " ms.");
	}
	
	private FilterInfo createFilterInfo(HttpServletRequest req) {
		FilterInfo info = new FilterInfo();
		info.setBrowserInfo(req.getHeader("User-Agent"));
		info.setDateTime(new Date(System.currentTimeMillis()));
		info.setParameters(Collections.list(req.getParameterNames()).stream().collect(Collectors.joining(",")));
		return info;
	}

}
//#### Zadanie 2 - rozwiązywane z wykładowcą
//
//1. Utwórz filtr, który będzie wyświetlał informacje o wykorzystywanej przez użytkownika przeglądarce,
// wykorzystaj nagłówek `User-Agent`.
//2. Obliczaj i wyświetlaj w konsoli czas wywołania żądania.
//Wykorzystaj poniższy kod w metodzie filtra:
//````java
//long startTime = System.currentTimeMillis();
//chain.doFilter(request, response);
//long stopTime = System.currentTimeMillis();
//````
//
//-----------------------------------------------------------------------------
//
//#### Zadanie 3
//
//Zmodyfikuj filtr z zadania 2, tak by pozyskane w filtrze dane zapisywał do bazy danych:
//    - przeglądarkę użytkownika
//    - datę i godzinę żądania
//    - wszystkie parametry żądania (zastanów się w jaki sposób przechowywać te dane w bazie)
//    - czas wykonania żądania