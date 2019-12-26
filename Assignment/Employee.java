package Assignment;

public class Employee extends Person {
	
	private Department dept;
	private int id;
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(String name, int id,Department dep) {
		super(name);
		dept = dep;
		this.id = id;
	}
	
	public Employee(String name,Address address, int id,Department dept) {
		super(name,address);
		this.dept = dept;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [dept=" + dept + ", id=" + id + ", Address=" + address + ", Name=" + name + " ]";
	}
	
	

}
