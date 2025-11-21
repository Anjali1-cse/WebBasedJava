package example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.entity.Department;
import example.entity.Employee;
import example.entity.Exam;

public class HibernateUtils {
//this class handles programmatic configuration and return SessionFactory
	public static SessionFactory getSessionFactory() throws Exception {
		
		Configuration cfg= new Configuration();
		//Adding configuration specific properties
		cfg.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/cdacs");
		cfg.setProperty("hibernate.connection.username","root");
		cfg.setProperty("hibernate.connection.password","Ycpait24");
		cfg.setProperty("hibernate.show_sql","true");
		cfg.setProperty("hibernate.hbm2ddl.auto","update");
		//adding the entity class to the configuration
		cfg.addAnnotatedClass(Exam.class);
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
		
		
	}
}
