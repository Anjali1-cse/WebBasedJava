package example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	public Student getOne(Integer studentId) {
		// this method accepts an  integer value Indicationg Student ID
		// and returns the Student object matching with that ID
		// if the ID non-existing it return null
		Student foundStudent = null;
		String sqlQuery =
		"SELECT STUDENT_NAME, STUDENT_CITY,STUDENT_ID from students where STUDENT_ID =? ";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				
				){
			// Substituting StudenId in place  of it
			 pstmt.setInt(1,studentId);
			 ResultSet rs=pstmt.executeQuery();
			 if(rs.next()){
				 String name = rs.getString(1);
					String city= rs.getString(2);
					int id  = rs.getInt(3); 
					foundStudent = new Student(id,name,city);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foundStudent ;
	}

	@Override
	public void create(Student studentObj) {
		// this method  accepts a student object and stores its as
		// record into Student table 
		String sqlQuery = "insert into students values(?,?,?)";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				
				){
			// fetching value from Student object
			String name = studentObj.getName();
			String city= studentObj.getCity();
			int id  =studentObj.getStudentId(); 
			//Substituting ? in place  with this
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "record Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Student modifiedStudentObj) {
		// This method receives modified state of student object 
		// and reflect that state back DB to complete the update operation
		String sqlQuery = 
				"update students set student_name=? ,student_city = ? where student_id=?";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				
				){
			// fetching value from Student object
			String name = modifiedStudentObj.getName();
			String city= modifiedStudentObj.getCity();
			int id  =modifiedStudentObj.getStudentId(); 
			//Substituting ? in place  with this
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setInt(3, id);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + " record updated ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOne(Integer studentId) {
		// This method accepts Id of the student and delete the relevant record
		// from the Db table.
		String sqlQuery = 
				"delete from students where student_id=?";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				
				){
			pstmt.setInt(1, studentId);
			int count = pstmt.executeUpdate();
			if (count != 0) {
				System.out.println(count+ " record deleted");
			}else
				System.out.println("student with this ID not exist.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
