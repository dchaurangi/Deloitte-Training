package jdbc;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmployeeHireDate {
	
	
Connection con = null;
ArrayList<Employee> list = new ArrayList<>();
	
	public EmployeeHireDate()
	{
		
	}
	
	public void listEmployeesBeforeDate(String date)
	{
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		String sql = "SELECT employee_id,first_name,last_name,department_id,salary,to_char(hire_date, 'fmDD-MON-YYYY') FROM employees WHERE hire_date <= ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, date);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				//list.add(rs.getString(1));
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				int depId= rs.getInt(4);
				double sal=rs.getDouble(5);
				String jdate=rs.getString(6);
				SimpleDateFormat sdf=new SimpleDateFormat("DD-MMM-YYYY");
				Date joinDate=null;
				try {
					joinDate=sdf.parse(jdate);
				}catch(ParseException e1) {
					e1.printStackTrace();
				}
				Employee e = new Employee(id,fname+" "+lname,depId,joinDate,sal);
				list.add(e);
				System.out.println(e);
				
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		//System.out.println(list.size());
	
	}
	
	public static void main(String [] args)
	{
		EmployeeHireDate elist = new EmployeeHireDate();
		elist.listEmployeesBeforeDate("01-JAN-10");
		System.out.println(elist.list.size());
		
	}

}
