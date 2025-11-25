package rest_impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //combines @controller and @ @ResponseBody
public class RestImpl {
 //this  class is meant for exposing Rest end points
	@GetMapping("/doGreet")
	public String getGreeting() {
		return "Welcome to Rest";
	}
	@GetMapping("/doGreetAgain")
	public Greeting getGreetingObject() {
		Greeting gr = new Greeting("happy new year", LocalDate.of(2026, 1, 1));
		return gr;
	}
	@GetMapping("/doGreetsAgain")
	public Collection<Greeting> getGreetingObjects() {
		Greeting gr = new Greeting("happy new year", LocalDate.of(2026, 1, 1));
		Greeting gr1 = new Greeting("marry Christmas", LocalDate.of(2025, 12, 25));
		Greeting gr2 = new Greeting("happy brithday", LocalDate.of(2026, 3, 15));
		List<Greeting> newList = List.of(gr, gr1,gr2);
		return newList;
		
	}
}
