package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrivalMain {

	public static void main(String[] args) {
		// Program to retrieve data from DB using Select Query and display it.
		// 1. LOAD Deriver
		String driverClass = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverClass);
			System.out.println("Deriver Load");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. Establish Connection
		String connectionUrl="jdbc:mysql://localhost:3306/cdacs?useSSL=false";
		String userId ="root";
		String password = "Ycpait24";
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet re = null;
		try {
			dbConnection = DriverManager.getConnection(connectionUrl,userId,password);
			System.out.println("connected to Db");
			
			//3.Obtain some Statement
			stmt = dbConnection.createStatement();
			
			//4.Execute SQL Query
			
			String sqlQuery =
					"SELECT STUDENT_NAME, STUDENT_CITY,STUDENT_ID from students";
			//5.For SELECT query, obtain ResultSet 
			re=stmt.executeQuery(sqlQuery);
			
			//Perform navigation.
			while(re.next()) {
				String name = re.getString(1);
				String city= re.getString(2);
				int id  = re.getInt(3);
				System.out.println(id +" , "+name+" , "+ city);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				re.close();
				stmt.close();
				dbConnection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
