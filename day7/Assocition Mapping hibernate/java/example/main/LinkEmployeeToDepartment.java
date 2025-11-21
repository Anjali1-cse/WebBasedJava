package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Department;
import example.entity.Employee;
import example.utils.HibernateUtils;

public class LinkEmployeeToDepartment {

	public static void main(String[] args) {
		try(
				 SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionObj = factory.openSession();
					
					){
			//Loading all Employee
		Employee emp = sessionObj.find(Employee.class, 101);
		Employee emp1 = sessionObj.find(Employee.class, 102);
		Employee emp2 = sessionObj.find(Employee.class, 103);
		Employee emp3 = sessionObj.find(Employee.class, 104);
		Employee emp4 = sessionObj.find(Employee.class, 105);
		//loading all department to which employee are to be linked
		Department dept = sessionObj.find(Department.class,11);
		Department dept1 = sessionObj.find(Department.class,12);
		Transaction tx = sessionObj.beginTransaction();
		// Populating a list of employees: emp1, emp2
		List<Employee> empList = List.of(emp,emp1,emp2);
		dept.setEmployeeList(empList);
		
		dept1.addEmployee(emp3);
		dept1.addEmployee(emp4);
		tx.commit();
		System.out.println("employee are linked to Department created succesfully");	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		}

}


