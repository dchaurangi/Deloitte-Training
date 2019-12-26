package person_people;

public class Person {
	
	private long mobilenumber;
	private String name;
	private static int instances=0;
	
	public Person()
	{
		++instances;
	}
	
	public Person(String name)
	{
		this(name,0L);
	}
	
	public Person(String name, long number) {
		
		this();
		this.name=name;
		mobilenumber=number;
		
	}

	public int getInstances()
	{
		return getInstances();
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setMobileNumber(long num)
	{
		mobilenumber=num;
	}
	
	public long getMobileNumber()
	{
		return mobilenumber;
	}
	@Override
	public String toString()
	{
		return name+" : "+mobilenumber;
	}

	public static void main(String[] args) {
		
		Person neha= new Person();
		neha.setName("Neha Das");
		neha.setMobileNumber(9685744512L);
		//System.out.println(neha.getName()+":"+neha.getMobileNumber());
		
		Person raj= new Person();
		raj.setName("Raj Sharma");
		raj.setMobileNumber(9685744512L);
		//System.out.println(raj.getName()+":"+raj.getMobileNumber());
		
		System.out.println(neha.toString());
		System.out.println(raj.toString());
		
		Person ramesh = new Person("Ramesh Verma",8574365914L);
		System.out.println(ramesh.toString());
		
		System.out.println(("No. of instances = "+instances));
		
		
	}

}
