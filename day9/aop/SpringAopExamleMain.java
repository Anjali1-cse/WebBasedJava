package example.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopExamleMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
		Musician mObj = context.getBean(Musician.class);// mobj-> refer to Porxy
		System.out.println("className: "+ mObj.getClass().getName());
		mObj.perform();
		System.out.println("=====================================");
		Singer sObj= context.getBean(Singer.class);
		System.out.println("className: "+ sObj.getClass().getName());
		sObj.perform();
		
	}

}
