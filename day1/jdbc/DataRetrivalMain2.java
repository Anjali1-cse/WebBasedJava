package example.jdbc;

import java.util.Collection;

public class DataRetrivalMain2 {

	public static void main(String[] args) {
	DaoInterface<Student ,Integer> daoRef=
			new StudentDao();
	Collection<Student> allstudent=daoRef.getAll();
//	for(Student s :allstudent ) {
//		System.out.println(s);
//	}
	allstudent.stream().forEach(student->System.out.println(student));
	}

}
