package compare;

public class Employee {
	private String name;
	private int id;
	
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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
	
	

}
