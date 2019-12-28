package WeeklyAssessment1;

import java.util.ArrayList;

public class OrgTest {
	
	
	
	static ArrayList<Employee1> emps = new ArrayList<Employee1>();
	static int i;

	public static void main(String[] args) {
		
		Department1 d1= new Department1("Admin","HYD");
		Department1 d2= new Department1("Devop","HYD");
		Department1 d3= new Department1("Testing","HYD");
		
		Role1 manager= new Role1("Manager");
		Role1 developer= new Role1("Developer");
		Role1 tester= new Role1("Tester");
		
		Employee1 e1 =new Employee1("Raja", 125, 58900, d1, manager, null);
		Employee1 e2 =new Employee1("Rajan", 874, 87500, d3, tester, e1);
		Employee1 e3 =new Employee1("Ayesha", 932, 41500, d2, developer, e1);
		Employee1 e4 =new Employee1("Ashu", 845, 10200, d1, developer, e1);
		Employee1 e5 =new Employee1("Hari", 102, 58900, d3, tester, e1);
		
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		
		System.out.println("Details of all employees");
		printEmployee();
		System.out.println("Details of employees with department");
		printEmployeeWithDept("Devop");
		System.out.println("Details of employees with role");
		printEmployeeWithRole("Tester");
		System.out.println("Details of all employees with salary incrementation");
		salaryIncrement(10.0);
		displayEmpSalInc();
		System.out.println("details of all employees with manager");
		displayEmpWithManager();

	}


	public static void printEmployee()
	{
		for(i=0;i<5;i++)
		{
				System.out.println(emps.get(i));
		}
	}
	
	public static void printEmployeeWithDept(String r)
	{
		for(i=0;i<5;i++)
		{
			if(emps.get(i).getDept().getName().equals(r))
				System.out.println(emps.get(i));
		}
	}
	public static void salaryIncrement(double r)
	{
		for(i=0;i<5;i++)
		{
			if(emps.get(i).getjRole()!=null)
			{
				emps.get(i).setSalary(emps.get(i).getSalary()+(r/100)*emps.get(i).getSalary());
		    }
		}
	}
	public static void printEmployeeWithRole(String r)
	{
		for(i=0;i<5;i++)
		{
			if(emps.get(i).getjRole().getJobRole().equals(r))
			{
				System.out.println(emps.get(i));
		    }
		}
	}
	
	
	
	public static void displayEmpSalInc()
	{
		for(i=0;i<5;i++)
		{
			if(emps.get(i).getjRole()!=null)
				System.out.println(emps.get(i));
		}
	}
	
	public static void displayEmpWithManager()
	{
		for(i=0;i<5;i++)
		{
			if(emps.get(i).getManager()!=null)
				System.out.println(emps.get(i));
		}
	}
	

}
