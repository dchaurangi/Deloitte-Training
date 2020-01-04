package WeeklyAssessment2;

public class Publisher {
	
	String pname;
	String pcity;

	public Publisher(String pname, String pcity) {
		super();
		this.pname = pname;
		this.pcity = pcity;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcity() {
		return pcity;
	}

	public void setPcity(String pcity) {
		this.pcity = pcity;
	}

	@Override
	public String toString() {
		return "Publisher name=" + pname + " Publisher city=" + pcity + "]";
	}
	
	

}
