package student_course;

public class Student {
	
	private long rollnumber;
	private String name;
	
	public Student(String name)
	{
		this(name,0L);
	}
	
	public Student(String name, long number) {
		
		this.name=name;
		rollnumber=number;
		
	}

	@Override
	public String toString() {
		return "Student [rollnumber=" + rollnumber + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(long rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
