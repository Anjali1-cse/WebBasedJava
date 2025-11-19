package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.jdbc.Student;

/**
 * Servlet implementation class DisplayStudentServlet
 */
@WebServlet("/doDisplay")
public class DisplayStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// retrieving the attribute: currentStudent from the incoming request
		Object obj = request.getAttribute("currentStudent");
		Student std = (Student)obj;
		String name = std.getName();
		String city = std.getCity();
		
		out.println("<h2>SHOWING STUDENT DETAILS</h2>");
		out.println("<h2>NAME: "+name+ "</h2>");
		out.println("<h2>CITY: "+city+ "</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
