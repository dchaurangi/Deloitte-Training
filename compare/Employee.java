package compare;

import java.util.Comparator;

public class Employee implements Comparable<Employee>, Comparator<Employee>{
	private String name;
	private int id;
	private double salary;
	
	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary=salary;
	}
	
	
	@Override
	public int hashCode()
	{
		return id/12;
	}
	@Override
	public boolean equals(Object o)
	{
		Employee e= (Employee)o;
		return this.id==e.id;// this.id refers to e1 and e.id refers to e2
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
	


	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}


	/*@Override
	public int compareTo(Employee other)
	{
		 return this.id-other.id;
	}*/
	
	@Override
	public int compare(Employee e1, Employee e2)
	{
		return e1.name.compareToIgnoreCase(e2.name);
	}
	
	@Override
	public int compareTo(Employee other)
	{
		 return (int) (this.salary-other.salary);
	}
	
	

}
