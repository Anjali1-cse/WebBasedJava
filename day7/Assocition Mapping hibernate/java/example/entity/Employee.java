package example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Employee_Master")
public class Employee {
	@Id
	@Column(name="empNo")
    private Integer empNO;
	@Column(name="emp_name", length = 30)
    private String name;
	@Column(name="emp_sal")
    private float salary;
	
	
	public Employee() {
		
	}


	public Employee(Integer empNO, String name, float salary) {
		super();
		this.empNO = empNO;
		this.name = name;
		this.salary = salary;
	}


	public Integer getEmpNO() {
		return empNO;
	}


	public void setEmpNO(Integer empNO) {
		this.empNO = empNO;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [empNO=" + empNO + ", name=" + name + ", salary=" + salary + "]";
	}
	

}
