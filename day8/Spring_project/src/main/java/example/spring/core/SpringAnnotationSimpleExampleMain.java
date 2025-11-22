package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationSimpleExampleMain {

	public static void main(String[] args) {
		// this class loads the bean configuration using anootation
		Class<SpringConfig> configClass = SpringConfig.class;
		ApplicationContext context = new  AnnotationConfigApplicationContext(configClass);
		Object obj = context.getBean("doWelcome");
		GreetingService gs = (GreetingService)obj;
		String reply = gs.sayGreeting();
		System.out.println(reply);
		System.out.println("==============================================================");
		Object obj1 = context.getBean("helloBean");
		GreetingService gs1 = (GreetingService)obj1;
		String reply1 = gs1.sayGreeting();
		System.out.println(reply1);
	}

}