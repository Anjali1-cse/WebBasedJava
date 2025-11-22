package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //marks this class as configuration
public class SpringConfig {
   // this class is meant for declaring bean or configuration bean
	// defining  a bean of type WelcomeService
	@Bean//marks this method as bean
	public GreetingService doWelcome() {
		GreetingService ws = new WeclomeService();
		return ws;
	}
	@Bean("helloBean")
	public GreetingService doHello() {
		GreetingService ws = new HelloService();
		return ws;
	}
}
