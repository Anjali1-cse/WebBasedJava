package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.bean.ExamNameDuration;
import example.entity.Exam;
import example.utils.HibernateUtils;

public class ConstructorExpressionMain {

    public static void main(String[] args) {
        try (
            SessionFactory factory = HibernateUtils.getSessionFactory();
            Session sessionObj = factory.openSession();
        ) {
            // HQL Select clause
            String hqlQuery = "select new example.bean.ExamNameDuration(ex.name, ex.duration) from Exam ex";

            Query<ExamNameDuration> queryRef = sessionObj.createQuery(hqlQuery, ExamNameDuration.class);

            List<ExamNameDuration> dataList = queryRef.getResultList();

            System.out.println("Exam Name | Duration");
            System.out.println("---------------------");

            // Print each row
            for (ExamNameDuration data : dataList) {
            	String examName = data.getExamNmae();
            	int examdur = data.getExamDuration();
                System.out.println(examName + " | " + examdur);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}