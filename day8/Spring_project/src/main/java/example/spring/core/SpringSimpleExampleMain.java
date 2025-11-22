package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSimpleExampleMain {

	public static void main(String[] args) {
	// this class loads the bean from spring's configuration unit and performs operation using that bean
       String configFilePath = "./src/main/resources/Spring-config.xml";
       ApplicationContext context = new FileSystemXmlApplicationContext(configFilePath);
       Object obj=  context.getBean("myBean");
       GreetingService gfg =  (GreetingService)obj;
       String reply =  gfg.sayGreeting();
       
      System.out.println(reply);
      Object obj1=  context.getBean("yourBean");
      GreetingService gfg1 =  (GreetingService)obj1;
      String reply1 =  gfg1.sayGreeting();
      System.out.println(reply1);
      
       //GreetingService gs =  new HelloService();
        // System.out.println(gs.sayGreeting());
      System.out.println("=====================================================");
       obj=  context.getBean("userBean");
       gfg =  (GreetingService)obj;
       reply =  gfg.sayGreeting();
       System.out.println(reply);
       System.out.println("=====================================================");
       obj=  context.getBean("userBean2");
       gfg =  (GreetingService)obj;
       reply =  gfg.sayGreeting();
       System.out.println(reply);
       
	}

}
