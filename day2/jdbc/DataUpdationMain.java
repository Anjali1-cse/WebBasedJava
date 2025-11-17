package example.jdbc;

public class DataUpdationMain {

	public static void main(String[] args) {
		DaoInterface<Student ,Integer> daoRef= new StudentDao();
		Student foundStudent = daoRef.getOne(107);
		if(foundStudent != null) {
			foundStudent.setName("aloo");
			foundStudent.setCity("govandi");
			daoRef.update(foundStudent);
		}
		else
			System.out.println("Student no exist with this ID");
	}

}
