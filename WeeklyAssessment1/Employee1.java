package WeeklyAssessment1;

public class Employee1 {
	
	private String name;
	private int id;
	private double salary; 
	private Department1 dept;
	private Role1 jRole;
	private Employee1 manager;
	

	public Employee1(String name, int id, double salary, Department1 dept, Role1 jRole, Employee1 manager) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.dept = dept;
		this.jRole = jRole;
		this.manager = manager;
		
	}

	public Employee1 getManager() {
		return manager;
	}
	public void setManager(Employee1 manager) {
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department1 getDept() {
		return dept;
	}
	public void setDept(Department1 dept) {
		this.dept = dept;
	}
	public Role1 getjRole() {
		return jRole;
	}
	public void setjRole(Role1 jRole) {
		this.jRole = jRole;
	}
	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", id=" + id + ", salary=" + salary + ", dept=" + dept + ", jRole=" + jRole
				+ ", manager=" + manager + "]";
	}
	
	

}
