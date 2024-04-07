package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchCourse
 */
@WebServlet("/courseDetails")
public class FetchCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx=getServletContext();
			List<String> list=(List<String>) ctx.getAttribute("courseInfo");
			PrintWriter out=response.getWriter();
			out.println("Course Details Are");
			out.println("<table border ='2'>");
			out.println("<thead>");
			out.println("<th>CourseDetails</th>");
			out.println("</thead>");
			for(String course:list)
			{
				out.println("<tr><td>"+course+"</td></tr>");
			}
			
			out.println("</table>");
			response.setContentType("text/html");
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
