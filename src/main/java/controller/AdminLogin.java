package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setting the content type or response type 
		response.setContentType("text/html");
		//createing object of PrintWriter
		PrintWriter out = response.getWriter();
		
		ServletContext context=getServletContext();
		String adminNameFromxmlFile=context.getInitParameter("userName");
		String adminPasswordFromXmlFile=context.getInitParameter("userPassword");
		
		
		String adminNameFromHtml=request.getParameter("t1");
		String adminPasswordFromHtml=request.getParameter("t2");
		
		//comparing both the inputs using the conditional statement 
		if(adminNameFromxmlFile.equalsIgnoreCase(adminNameFromHtml)&&
			adminPasswordFromXmlFile.equals(adminPasswordFromHtml)	
				)
		{
			out.println("welcome"+"+adminNameFromxmlFile");
			out.println("your server info is" + " "+context.getServerInfo());
			List<String> list = new ArrayList();
			list.add("java course in 2000.00");
			list.add("python course in 3000.00");
			list.add("sql in 1000.00");
			//finding global object with ServletContext
			context.setAttribute("courseInfo",list);
			RequestDispatcher rd=request.getRequestDispatcher("getCourses.html");
			rd.include(request, response);
		}
		
		
		
		
		
		
		
	}

}
