/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingExamForPlebs.TxtToCsv;

/**
 *
 * @author przyg
 */
public class ListCity {
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
	
	
	public ListCity(String name, double latitude, double longitude)
	{
		this.name = name;
		this.latitude = latitude;
                this.longitude = longitude;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
