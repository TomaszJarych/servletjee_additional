package pl.coderslab.mvc1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Mvc01" }, initParams = { @WebInitParam(name = "exchangeRate", value = "4.33") })
public class Mvc01 extends HttpServlet {
	private double exchangeRate;
	@Override
	public void init(ServletConfig config) throws ServletException {
		exchangeRate = Double.parseDouble(config.getInitParameter("exchangeRate"));
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg;
		try {
			double pln = Double.parseDouble(request.getParameter("euro"))*exchangeRate;
			msg = "W PLN kwota "+request.getParameter("euro")+ " EUR to "+pln+" zl";
			
			
		} catch (Exception e) {
			msg = "Bledne wartosci";
		}
		request.setAttribute("pln", msg);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc01/mvc01.jsp").forward(request, response);
	}

}
