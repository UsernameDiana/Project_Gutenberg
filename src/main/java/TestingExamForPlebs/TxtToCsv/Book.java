package TestingExamForPlebs.TxtToCsv;

public class Book {
	
	String title;
	int bookID;
	
	public Book(String title, int bookID) {
		this.title = title;
		this.bookID = bookID;
	}
	
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public int getBookID()
	{
		return this.bookID;
	}
}
