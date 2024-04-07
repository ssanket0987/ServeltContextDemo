package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankServer
 */
//@WebServlet("/BankServer")
public class BankServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting the object of the servletConfig
		ServletConfig config = getServletConfig();

		String pinCode = config.getInitParameter("pin");
		String adminName = config.getInitParameter("server-admin");
		PrintWriter out = response.getWriter();
		String servletName = config.getServletName();
		ServletContext context=config.getServletContext();
		String contextPath = context.getContextPath();

		out.println("pin for server is" + " " + pinCode);
		out.println("adminName:" + " " + adminName);
		out.println("servlet name info:" + " " + servletName);
		out.println("servlet path info:" + " " + contextPath);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
