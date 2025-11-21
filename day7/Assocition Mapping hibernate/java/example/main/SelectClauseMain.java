package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class SelectClauseMain {

    public static void main(String[] args) {
        try (
            SessionFactory factory = HibernateUtils.getSessionFactory();
            Session sessionObj = factory.openSession();
        ) {
            // HQL Select clause
            String hqlQuery = "select ex.name, ex.duration from Exam ex";

            Query<Object[]> queryRef = sessionObj.createQuery(hqlQuery, Object[].class);

            List<Object[]> dataList = queryRef.getResultList();

            System.out.println("Exam Name | Duration");
            System.out.println("---------------------");

            // Print each row
            for (Object[] row : dataList) {
            	Object examName = row[0];
            	Object examdur = row[1];
                System.out.println(examName + " | " + examdur);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}