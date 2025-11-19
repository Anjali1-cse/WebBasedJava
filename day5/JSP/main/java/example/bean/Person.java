package example.bean;

public class Person {

	
		private String name;
		private int age;
		private float weight;
		
		public Person() {
			super();
			System.out.println("inside person");
		}

		public Person(String name, int age, float weight) {
			super();
			this.name = name;
			this.age = age;
			this.weight = weight;
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
			System.out.println("setting age");
			this.age = age;
			
		}

		public float getWeight() {
			System.out.println("getting weight");
			return weight;
		}

		public void setWeight(float weight) {
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
		}



}
