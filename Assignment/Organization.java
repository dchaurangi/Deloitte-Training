package Assignment;

public class Organization {

	static Employee[] emps = new Employee[5];
	static int i;
	
	public static void main(String[] args) {
		
		Department hr= new Department("HR","Hyd");
		Department dev= new Department("DEV","Hyd");
		Department test= new Department("TEST","Hyd");
		
		Address a1= new Address(123, "Rajnagar", "Hyd","TS");
		Address a2= new Address(23, "Indiranagar", "Hyd","TS");
		Address a3= new Address(158, "o/L Street", "Hyd","TS");
		Address a4= new Address(874, "Ramnagar", "Hyd","TS");
		Address a5= new Address(201, "El street", "Hyd","TS");
		
		Employee e1 =new Employee("Raja", a1, 520, hr);
		Employee e2 =new Employee("Niraj", a2, 158, dev);
		Employee e3 =new Employee("Neha", a3, 964, dev);
		Employee e4 =new Employee("Rahul", a4, 874, dev);
		Employee e5 =new Employee("Sujay", a5, 587, null);
		
		/*System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e5);*/
		
		emps[0]=e1;
		emps[1]=e2;
		emps[2]=e3;
		emps[3]=e4;
		emps[4]=e5;
		
		printEmployee("DEV");
		getDepartment(e4);
		printEmployeeNotDept();
		
	}
	
	public static void printEmployee(String Dept)
	{
		for(i=0;i<5;i++)
		{
			if(emps[i].getDept()!=null && emps[i].getDept().getDname().equals(Dept))
				System.out.println(emps[i]);
		}
	}
	
	public static void getDepartment(Employee e)
	{
		System.out.println(e.getDept().getDname());
	}

	public static void printEmployeeNotDept()
	{
		for(i=0;i<5;i++)
		{
			if(emps[i].getDept()==null)
				System.out.println(emps[i]);
		}
	}
	
}
