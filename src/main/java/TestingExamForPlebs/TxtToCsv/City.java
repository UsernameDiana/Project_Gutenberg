package TestingExamForPlebs.TxtToCsv;

public class City {

	String name;
	int bookID;
	
	
	public City(String name, int bookID)
	{
		this.name = name;
		this.bookID = bookID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBookID() {
		return this.bookID;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
}
