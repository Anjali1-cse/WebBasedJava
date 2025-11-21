package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class UpdateExamMain2 {

	public static void main(String[] args) {
		// this class is used to update a single exam record based on its ID
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj= factory.openSession()
				){
			//Class<Exam>examClassType = ;
			//Object examCode="103";
		  Exam	foundExam=sessionObj.find(Exam.class, "103");
		  if(foundExam != null) {
			  Transaction tx =  sessionObj.beginTransaction();
			  foundExam.setName("Jakara EE");
			  foundExam.setCode("Lab");
			  tx.commit();
			  System.out.println("exam record updates successfully.");
		  }      
		  else
			  System.out.println("Exam with given Id does not exist.");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
