package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import first.FirstComponent;
import second.SecondComponent;
import second.child.SecondChildComponent;

public class PureAnnotationExampleMain {
   public static void main(String[]args) {
	   ApplicationContext context = new  AnnotationConfigApplicationContext(SpringAppConfig.class);
	   ManagedComponent managedComp = context.getBean(ManagedComponent.class);
	   managedComp.doManage();
	   
	   FirstComponent firstComp =  context.getBean(FirstComponent.class);
	   firstComp.doManage();
	   SecondComponent  secondCom = context.getBean(SecondComponent.class);
	   secondCom.doManage();
	   SecondChildComponent secondChildComp = context.getBean( SecondChildComponent.class);
	   secondChildComp.doManage();
   }
}
