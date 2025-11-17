package example.jdbc;

public class DataDelelteMain {

	public static void main(String[] args) {
		DaoInterface<Student ,Integer> daoRef= new StudentDao();
		daoRef.deleteOne(104);

	}

}
