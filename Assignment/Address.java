package Assignment;

public class Address {

	private int hno;
	private String street;
	private String city;
	private String state;
	public Address(int hno, String street, String city, String state) {
		super();
		this.hno = hno;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [hno=" + hno + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	
	
	
	
	
}
