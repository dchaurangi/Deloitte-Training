package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MyCollection {

	public static  void main(String[] args) {
		
		int sum=0;
		Vector<String> v = new Vector<>();
		v.add("Arjun");
		v.add("123");
		v.add("Shyam");
		int len = v.size();
		System.out.println(len);
		//Traditional for loop
		for(int i=0;i<len;i++)
			System.out.println(v.get(i));
		//Enhanced for loop
		for (String s:v)
		{
			System.out.println(s);
		}
		//Using Enumation
		Enumeration<String> e= v.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		//Using iterator
		Iterator<String> it = v.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		//Insertion using Array List
		ArrayList<Integer> list = new ArrayList<>();
		list.add(51);
		list.add(43);
		list.add(12);
		list.add(23);
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		//Sum of all numbers in th list
		for(int i=0;i<=len;i++)
			sum=sum+list.get(i);
			System.out.println(sum);
		//Sorting the elements in the lsit
		Collections.sort(list); 
			System.out.println(list);
			
		//
		List<Student> students = new ArrayList<>();
		students.add(new Student("Mona",123));
		students.add(new Student("Hena",587));
		students.add(new Student("Neha",987));
		students.add(new Student("Akhil",201));
		students.add(new Student("Ana",123));
		students.add(new Student("Anny",587));
		students.add(new Student("Ayesha",987));
		students.add(new Student("Anuj",201));
		
		Iterator<Student> sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getName());
		}
		
		//Sorting using names
		/*Collections.sort(students, new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}
		});
		
		sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getName());
			
		}*/	
		

		//Sorting using roll number
		/*Collections.sort(students, new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.getRoll() - s2.getRoll();
		}
		});
				
		sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getName());
		
	}*/
		
		//print all name start with 'A'
		System.out.println("----------------------");
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
			});
			
			sdIt = students.iterator();
			while(sdIt.hasNext()) {
				Student st = sdIt.next();
				if((st.getName().startsWith("A"))==true)
					System.out.println(st.getName());
				
			}	
		
		//Collections.sort(students,  new StudentNameSorter());
		System.out.print(getRollNumber(students, "Ana"));
		
}
	
	
	public static int getRollNumber(List<Student> list, String studentName)
	{
		for(Student s : list) {
			if(s.getName().equalsIgnoreCase(studentName)) {
				return s.getRoll();
			
		}
			
	}
		return 0;
		
	}
}