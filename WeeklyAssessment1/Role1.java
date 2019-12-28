package WeeklyAssessment1;

public class Role1 {
	
	
	private String jobRole;

	public Role1(String jobRole) {
		super();
		this.jobRole = jobRole;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	@Override
	public String toString() {
		return "Role1 [jobRole=" + jobRole + "]";
	}
	
	

}
