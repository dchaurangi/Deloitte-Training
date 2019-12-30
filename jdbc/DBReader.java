package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReader {

	public static void main(String[] args) {
		//1.Load the driver
		Connection con = null;
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver not found"+e.getMessage());
		}
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "hr";
		String password = "hr";
		//2.Get connection
		try {
			con = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			System.out.println("Connection failed. "+e.getMessage());
		}
		//3.Create a statement object
		String sql = "select count(*) from employees";
		
		try {
			Statement st= con.createStatement();
			//4.pass sql query string and execute statement
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("employee_id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				System.out.println(id+":"+fname+":"+lname);
			}
			rs.close();
			st.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

}