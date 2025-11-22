package example.spring.core;

public class UserService implements GreetingService {
    
   private String name;
   private int age;
		public UserService() {
		super();
	}
	public UserService(String name, int age) {
		System.out.println("Inside UserService string,int");
		this.name = name;
		this.age = age;
	}
	public UserService(int age, String name) {
		System.out.println("Inside UserService int, string");
		this.age = age;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String sayGreeting() {
	  String greeting = "h1 "+ name + ", your age  is " + age;
		return greeting;
	}


}
