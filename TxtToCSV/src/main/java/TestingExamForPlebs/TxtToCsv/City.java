package TestingExamForPlebs.TxtToCsv;

public class City {

	String name;
	int bookID;
        double longitude;
        double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
	
	
	public City(String name, int bookID, double latitude, double longitude)
	{
		this.name = name;
		this.bookID = bookID;
                this.latitude = latitude;
                this.longitude = longitude;
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
