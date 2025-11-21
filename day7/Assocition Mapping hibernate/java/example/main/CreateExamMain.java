package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;


public class CreateExamMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj= factory.openSession()
				){
			Exam examObj = new Exam("102", "DBT", "theroy",60);
			Transaction tx = sessionObj.beginTransaction();
			sessionObj.persist(examObj);// store the data
			tx.commit();
			System.out.println("exam created succesfully");
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
