package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/doGreet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() {
	   System.out.println("inside init(2) ");	
	}
	@Override

	public void destroy()
	{
		  System.out.println("inside destroy(2)");	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("reqest received");
		response.setContentType("text/html");//MIME - Multipurpose internet mail extensions
		String responseText =
				"<h1 style='color:red'>Welcome to Servlets</h1>";
		PrintWriter out = response.getWriter();
			out.println(responseText);	
	}

}
