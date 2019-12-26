package Assignment;

public class Person {

	protected String name;
	protected Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
	
	
}
