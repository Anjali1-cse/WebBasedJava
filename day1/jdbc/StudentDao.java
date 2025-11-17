package example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements DaoInterface<Student, Integer> {

	@Override
	public Collection<Student> getAll() {
		// this method retrieves all the records from students table 
		// covert them into java objects of Students  class and return
		// all those object in  the form of Collection
		
		// Declaring an empty Collection meant for holding object 
		// of type:Student
		Collection<Student> allStudents = new ArrayList();
		String sqlQuery =
				"SELECT STUDENT_NAME, STUDENT_CITY,STUDENT_ID from students";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				)
		{
			while(rs.next()) {
				String name = rs.getString(1);
				String city= rs.getString(2);
				int id  = rs.getInt(3);
				// create an object of student class based upon Id name city
			 Student studentObj = new Student(id,name,city);
			 allStudents.add(studentObj);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allStudents;
	}

}
