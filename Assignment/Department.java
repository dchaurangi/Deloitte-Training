package Assignment;

public class Department {
	
	private String dname;
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Department(String dname,String city) {
		super();
		this.dname=dname;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Department [city=" + city + ",Deptname=" + dname + "]";
	}
	
	

}
