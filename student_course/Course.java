package student_course;



public class Course {
	
	private String sub1;
	private String sub2;
	private Student[] stds;
	private int pers=5,counter=0,numcourses=0;
	
	private Course[] courses=new Course[1];
	
	public Course()
	{
		stds = new Student[pers];
	}
	
	public Student[] getStudentsArray() {
		
		return stds;
	}
	
	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}

	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}

	public void addStudent(Student st)
	{
		if(counter<pers)
			stds[counter++]=st;
		else
			System.out.println("Course is filled");
	}
	
	public void addCourse(Course c)
	{
		if(numcourses < pers)
			courses[numcourses++]=c;
	}
	public void display()
	{
		for (Student s : stds)
			System.out.println(s);
	}
	
	public void printStudentNames(String subject)
	{
		for(Course c: courses)
		{
			if(c.getSub1().equalsIgnoreCase(subject)||(c.getSub2().equalsIgnoreCase(subject)));
				Student[] students = c.getStudentsArray();
				for(Student s: students)
				{
					System.out.println(s);
				}
		}
	}
	

	public static void main(String[] args) {
		
		Course phys=new Course();
		phys.setSub1("mechanics");
		phys.setSub1("Wave theory");
		
		phys.addStudent(new Student("amit",14587));
		phys.addStudent(new Student("amit",87497));
		
		phys.display();
		phys.printStudentNames("Wave theory");

	}

}
