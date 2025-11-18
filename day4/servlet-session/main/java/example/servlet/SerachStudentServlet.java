package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.jdbc.DaoInterface;
import example.jdbc.Student;
import example.jdbc.StudentDao;

/**
 * Servlet implementation class SerachStudentServlet
 */
@WebServlet("/doSearch")
public class SerachStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//featching StudentID as a REquest Parameter
		String student_id = request.getParameter("StudentId");
		int studentId = Integer.parseInt(student_id);
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		Student foundStudent  = daoRef.getOne(studentId);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		 if(foundStudent != null) {
			//Send this student to the next servlet which is display the student
			 //out.println("<h2>Student Found</h2");
			 // obtaining RequestDispatcher for the next servets:do display
			 
			dispatcher= request.getRequestDispatcher("doDisplay");
			// attaching the found student: foundStudent to exting request
			request.setAttribute("currentStudent", foundStudent);
			// forwarding the request
			dispatcher.forward(request, response);
			 }
		 else
			 //redirect the control to search_student.html page and
			 			//display some appropriate message
			 // obtaining RequestDispatcher for previous Html:serach_student.html
			 
			 out.println("<h2>Student with given ID does no exist, please try again</h2");
		    dispatcher= request.getRequestDispatcher("searchStudent.html");
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
