package example.jdbc;

public class DataInsertionMain {

	public static void main(String[] args) {
		DaoInterface<Student ,Integer> daoRef=
				new StudentDao();
		
		Student std = new Student(104,"Anju","Faridabd");
		daoRef.create(std);

	}

}
