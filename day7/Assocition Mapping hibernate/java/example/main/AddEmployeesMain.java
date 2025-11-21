package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Employee;
import example.utils.HibernateUtils;

public class AddEmployeesMain {

	public static void main(String[] args) {
		// add employee in Employee master table
		try(
			 SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession();
				
				){
			Employee emp = new Employee(101,"anjali",20000);
			Employee emp1 = new Employee(102,"anju",2000);
			Employee emp2 = new Employee(103,"kaja",10000);
			Employee emp3 = new Employee(104,"neha",15000);
			Employee emp4 = new Employee(105,"raja",12200);
			Transaction tx = sessionObj.beginTransaction();
			sessionObj.persist(emp);
			sessionObj.persist(emp1);
			sessionObj.persist(emp2);
			sessionObj.persist(emp3);
			sessionObj.persist(emp4);
			tx.commit();
			System.out.println("Employee created succesfully");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
