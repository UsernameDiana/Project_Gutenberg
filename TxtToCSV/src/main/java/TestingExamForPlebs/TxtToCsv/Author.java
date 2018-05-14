package TestingExamForPlebs.TxtToCsv;

public class Author {

	String name;
	int bookID;
	
	public Author(String name, int bookID) {
		this.name = name;
		this.bookID = bookID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public int getBookID() {
		return this.bookID;
	}
}
