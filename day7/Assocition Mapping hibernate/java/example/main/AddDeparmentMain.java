package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Department;
import example.entity.Employee;
import example.utils.HibernateUtils;

public class AddDeparmentMain {

	public static void main(String[] args) {
		try(
				 SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionObj = factory.openSession();
					
					){
			Department dept = new Department(11,"IT","Pune",null);
			Department dept1 = new Department(12,"Finace","Mumbai",null);	
				Transaction tx = sessionObj.beginTransaction();
				sessionObj.persist(dept);
				sessionObj.persist(dept1);
				
				tx.commit();
				System.out.println("Department created succesfully");
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}

	}

}
