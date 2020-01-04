package WeeklyAssessment2;

public class Author {
	
	String aname;
	String nationality;

	public Author(String aname, String nationality) {
		super();
		this.aname = aname;
		this.nationality = nationality;
	}
	public Author(String aname) {
		super();
		this.aname = aname;
		
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Author name=" + aname + "";
	}
	
	

}
