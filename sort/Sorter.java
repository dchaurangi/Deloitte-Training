package sort;

import java.util.Arrays;
import java.util.Comparator;

import compare.Employee;

public class Sorter {

	public static void main(String[] args) {

		//String[] str= {"Raman","Akhil","Sushil","Babu","Hari","Arjun","Mani"};
		//stringSort(args);
		Employee e1 = new Employee("Ankit", 987,345.45);
		Employee e2 = new Employee("Rahul", 514, 231.45);
		Employee e3 = new Employee("Sujan", 100, 312.56);
		Employee e4 = new Employee("Mohul", 478, 123.89);
		Employee e5 = new Employee("Aneshwa", 201, 412.78);
		Employee e6 = new Employee("Akhil", 187, 120.01);
		
		Employee emps[] = new Employee[6];
		emps[0]=e1;
		emps[1]=e2;
		emps[2]=e3;
		emps[3]=e4;
		emps[4]=e5;
		emps[5]=e6;
		
		//Arrays.sort(emps);  //for sorting using the id
		//Arrays.sort(emps, e5); //sorting using name
		
		//Descending sorting basis on names
		/*Arrays.sort(emps, new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2)
		{
			return e2.getName().compareToIgnoreCase(e1.getName());
		}
		
		});*/
		
		
		
		//Descending sorting basis on ids
		/*Arrays.sort(emps, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2)
			{
				return e2.getId()-e1.getId();
			}
			
			});*/
		//Descending sorting basis on salary
				Arrays.sort(emps, new Comparator<Employee>() {
					@Override
					public int compare(Employee e1, Employee e2)
					{
						return (int) (e2.getSalary()-e1.getSalary());
					}
					
					});
				
				for(Employee e : emps)
				{
					System.out.println(e);
				}
		
		
	}

	
	
	public static void stringSort(String [] str)
	{
		Arrays.sort(str);
		for(int i=0;i<str.length;i++)
			System.out.println(str[i]);
	}
	
	
	
}

