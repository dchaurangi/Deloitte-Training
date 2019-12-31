package jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	int id;
	String fullName;
	int deptId;
	Date joinDate;
	double salary;
	
	public Employee(int id, String fullName, int deptId, Date joinDate, double salary) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.deptId = deptId;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY");
		String dt = formatter.format(joinDate);
		return "Employee [id=" + id + ", fullName=" + fullName + ", deptId=" + deptId + ", joinDate=" + dt
				+ ", salary=" + salary + "]";
	}
	
	

}
