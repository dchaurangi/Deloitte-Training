package WeeklyAssessment2;

public class Book {
	
	long isbn;
	String title;
	int pages;
	int pub_year;
	String types;
	Author auth;
	Publisher pub;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(long isbn, String title, int pages, int pub_year, String types, Author auth, Publisher pub) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.pub_year = pub_year;
		this.types = types;
		this.auth = auth;
		this.pub = pub;
	}
	
	
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPub_year() {
		return pub_year;
	}

	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Author getAuth() {
		return auth;
	}

	public void setAuth(Author auth) {
		this.auth = auth;
	}

	public Publisher getPub() {
		return pub;
	}

	public void setPub(Publisher pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", pub_year=" + pub_year + ", types="
				+ types + ", auth=" + auth + ", pub=" + pub + "]";
	}
	
	

}
