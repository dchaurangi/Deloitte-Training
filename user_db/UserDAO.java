package user_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {
	
	Connection con = null;
	ArrayList<User> list = new ArrayList<>();
	public UserDAO()
	{
		
	}
	
	public void listUsers()
	{
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		String sql = "select u.userid,u.fname,u.username,u.password,u.emailid,u.mobile,r.rolename\r\n" + 
				"from users u,roles r\r\n" + 
				"where u.roleid=r.roleid";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while(rs.next())
			{
				int userid=rs.getInt(1);
				String name=rs.getString(2);
				String username=rs.getString(3);
				String password="**********";
				String emailid=rs.getString(5);
				String mobile=rs.getString(6);
				Role role = new Role(rs.getString(7)); 
				User u = new User(userid,name,username,password,emailid,mobile,role);
				list.add(u);
				System.out.println(u);
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		
	
	}
	
	
	public void roleOfUsers(String name)
	{
		for(User u: list) {
			if(u.getfName().equalsIgnoreCase(name)) {
				System.out.println(u.getRl().getRoleName());
			}
		}
		
	}
	
	public static void main(String [] args)
	{
		UserDAO udao = new UserDAO();
		udao.listUsers();
		udao.roleOfUsers("Ravi");
	}
}
