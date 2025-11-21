package example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Department_Master")
public class Department {
    @Id
    @Column(name = "dept_no")
	private Integer deptno;
    @Column(name = "dept_name", length=30)
	private String name;
    @Column(name = "dept_loc", length=30)
	private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "dept_id")// foreign key column from child table// employee_master
	private List<Employee> employeeList;
	
	public Department() {
		employeeList = new ArrayList<>();
	}

	public Department(Integer deptno, String name, String location, List<Employee> employeeList) {
		super();
		this.deptno = deptno;
		this.name = name;
		this.location = location;
		this.employeeList = employeeList;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + ", employeeList="
				+ employeeList + "]";
	}
	// Providing an additional utiltiy method that alwo user to add a single 
	//Employee at a time.
	public void addEmployee(Employee emp) {
		employeeList.add(emp);
	}

}
