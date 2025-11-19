package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/doCount")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();

		// obtaining a session of current user(client)
		
		HttpSession session = request.getSession();
		//checking whether the session is newly create or not
		int countValue=0;
		if(session.isNew()) {
			countValue=1;
		}else {
			//otaining the previous count value from the existing session
			Object obj= session.getAttribute("currentCount");
			Integer previousCount = (Integer)obj;
			countValue = previousCount+1;
			
		}
		//attaching  the count value to the the session
		session.setAttribute("currentCount", countValue);
		// displaying the countValue
		out.println("<h2>Hit Count:" + countValue +"</h2");
		// redirecting to control to html page \: Counter.html
		RequestDispatcher dispatcher = request.getRequestDispatcher("Counter.html");
		dispatcher.include(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
