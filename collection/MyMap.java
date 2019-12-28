package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyMap {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "Laptop");
		map.put(2, "Mobile");
		map.put(3, "Tablet");
		map.put(4, "Desktop");
		map.put(5, "Palmtop");
		
		String device = map.get(3);
		System.out.println(device);
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext())
		{
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		getStudentMap();
		System.out.println(getStudentName(501));
		
	}
	
	public static String getStudentName(int rollNum) {
		Map<Integer , Student> map = getStudentMap();
		if(map.containsKey(rollNum)) {
			Student st = map.get(rollNum);
			return st.getName();
		}
		return null;
	}
	
	public static Map getStudentMap()
	{
		Map<Integer, Student> stds= new HashMap<>();
		List<Student> list = new ArrayList<>();
		Student s1 = new Student ("Akash",585);
		Student s2 = new Student ("Makash",874);
		Student s3= new Student ("Prakash",934);
		Student s4 = new Student ("Trakash",417);
		Student s5 = new Student ("Akishka",501);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		Iterator<Student> its = list.iterator();
		while(its.hasNext())
		{
			Student st=its.next();
			stds.put(st.getRoll(),  st);
		}
		return stds;
	}

}
