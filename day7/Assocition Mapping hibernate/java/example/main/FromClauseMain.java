package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class FromClauseMain {

	public static void main(String[] args) {
		//Retriever all record and displays
  
		try(
				 SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionObj = factory.openSession();
					
					){
			String hqlQuery = "from Exam ex";
			Query<Exam> queryRef =
			  sessionObj.createQuery(hqlQuery,Exam.class);
			  List<Exam> examList  = queryRef.getResultList();
			  for(Exam currentExam : examList)
				  System.out.println(currentExam);
			   examList.stream().forEach(exam-> System.out.println(exam.getName()));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		}
	}


