package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class DeleteExamMain3 {

	public static void main(String[] args) {
		// this class is used to delete a single exam record based on its ID
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj= factory.openSession()
				){
			//Class<Exam>examClassType = ;
			//Object examCode="103";
		  Exam	foundExam=sessionObj.find(Exam.class, "103");
		  if(foundExam != null) {
			  Transaction tx =  sessionObj.beginTransaction();
			  sessionObj.remove(foundExam);
			  tx.commit();
			  System.out.println("exam record delete successfully.");
		  }      
		  else
			  System.out.println("Exam with given Id does not exist.");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
