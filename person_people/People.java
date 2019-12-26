package person_people;

public class People {
	
	private Person[] persons;
	int pers=5,counter=0;
	
	public People()
	{
		persons = new Person[pers];
	}
	
	public void addPerson(Person p)
	{
		if(counter < pers)
		{
		persons[counter++]=p;
		}
	}
	
	public void displayPerson()
	{
		for(Person p : persons)
		{
			System.out.println(p);
		}
	}

	public static void main(String[] args) {
		
		People ppl= new People();
		ppl.addPerson(new Person("Amit",1478523690L));
		ppl.addPerson(new Person("Pulkit",1447895690L));
		ppl.addPerson(new Person("Satish",8745873690L));
		ppl.addPerson(new Person("Amrit",1478500140L));
		ppl.addPerson(new Person("Arpit",1897845560L));
		ppl.displayPerson();
	}

}
