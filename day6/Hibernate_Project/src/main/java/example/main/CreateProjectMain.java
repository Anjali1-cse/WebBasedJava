package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Project;

public class CreateProjectMain {

	public static void main(String[] args) {
		// configure HiBernate
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		//Obtain SessionFactory
		SessionFactory factory =null;
		Session sessionObj=null;
	try {
		//obtain SessionFactory
		factory=cfg.buildSessionFactory();
		//obtain  Session
		sessionObj= factory.openSession();
		//Instantiate Entity Class (Create an object of Entity class)
		Project myProject=
				 new Project(102,"Hotel Booking","Python",15);
		//obtain Transaction
		Transaction tx = sessionObj.beginTransaction();
		// store data in DB
		sessionObj.persist(myProject);//store
		//commit the transaction to save changes
		tx.commit();
		//close session oe sessionFactory
		sessionObj.close();
		factory.close();
		System.out.println("add sucessfully!");
		
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	     

	}

}
