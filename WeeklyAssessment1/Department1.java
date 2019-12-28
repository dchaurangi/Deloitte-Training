package WeeklyAssessment1;

public class Department1 {
	
	private String name;
	private String add;
	
	public Department1(String name, String add) {
		super();
		this.name = name;
		this.add = add;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return "Department1 [name=" + name + ", add=" + add + "]";
	}
	
	

}
