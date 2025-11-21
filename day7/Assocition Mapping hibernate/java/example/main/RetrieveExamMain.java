package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class RetrieveExamMain {

	public static void main(String[] args) {
		// this class is used to fetch a single exam record based on its ID
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj= factory.openSession()
				){
			Class<Exam>examClassType = Exam.class;
			Object examCode="103";
		  Exam	foundExam=sessionObj.find(examClassType, examCode);
		  if(foundExam != null)
		        System.out.println(foundExam);
		  else
			  System.out.println("Exam with given Id does not exist.");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
