package WeeklyAssessment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DAO {
	
	Connection con = null;
	static ArrayList<Book> list = new ArrayList<>();
	
	public void listBooks()
	{
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		
		String sql = "select b.isbn,b.title,b.pages,b.pub_year,b.type,a.auth_name,a.nationality,p.pub_name,p.pub_city\r\n" + 
				"from book b, author a, publisher p\r\n" + 
				"where b.auth_id=a.auth_id OR b.pub_id=p.pub_id";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				long isbn=rs.getLong(1);
				String title=rs.getString(2);
				int pages=rs.getInt(3);
				int pub_year=rs.getInt(4);
				String type=rs.getString(5);
				Author auth = new Author(rs.getString(6)); 
				Publisher pub = new Publisher(rs.getString(7),rs.getString(8));
			
				Book bk = new Book(isbn,title,pages,pub_year,type,auth,pub);

				list.add(bk);
				System.out.println(rs.getLong(1)+":"+rs.getString(2)+":"+rs.getInt(3)+":"+rs.getInt(4)+":"+rs.getString(5)+":"+auth+":"+pub);
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		
	
	}
	
	
	
	public void sortBooks()
	{
		
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		
		String sql = "select b.isbn,b.title,b.pages,b.pub_year,b.type,a.auth_name,a.nationality,p.pub_name,p.pub_city\r\n" + 
				"from book b, author a, publisher p\r\n" + 
				"where b.auth_id=a.auth_id OR b.pub_id=p.pub_id\r\n" + 
				"order by b.title, a.auth_id";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Author auth = new Author(rs.getString(6),rs.getString(7)); 
				Publisher pub = new Publisher(rs.getString(8),rs.getString(9));
				System.out.println(rs.getLong(1)+":"+rs.getString(2)+":"+rs.getInt(3)+":"+rs.getInt(4)+":"+rs.getString(5)+":"+auth+":"+pub);
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		
	}
	
	public static void listBookAfterDate(int x)
	{
		for(Book b: list){
			if(b.getPub_year()>=x) {
				System.out.println("ISBN : "+b.getIsbn()+",Book name : "+b.getTitle());
			}
	}
	}
	
	public static void listPoemInCity(String city)
	{
		for(Book b: list){
			if(b.getPub().getPcity().equalsIgnoreCase(city)||b.getTypes().equalsIgnoreCase("Poems")) {
				System.out.println(b.getTitle());
		}
	}
	}
	
	public void groupByAuthor()
	{
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		
		String sql = "select count(*)\r\n" + 
				"from book b, author a, publisher p\r\n" + 
				"where b.auth_id=a.auth_id OR b.pub_id=p.pub_id\r\n" + 
				"group by a.auth_name";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		
	}
	
	
	public static void main(String [] args)
	{
		DAO dao = new DAO();
		System.out.println("Display all book details");
		dao.listBooks();
		System.out.println("Display after sorting");
		dao.sortBooks();
		System.out.println("Display books after the specified dates");
		listBookAfterDate(2005);
		System.out.println("Display books of this city");
		listPoemInCity("HYD");
		System.out.println("Display the no. of books of a particular author");
		dao.groupByAuthor();
		
		
	}
}
