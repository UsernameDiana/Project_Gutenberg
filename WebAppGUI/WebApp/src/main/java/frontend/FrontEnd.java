package frontend;

/**
 *
 * @author diana
 */
public class FrontEnd {
    private String city;
    private String bookTitles;
    private String authors;

    public FrontEnd() {
       city = null;
    }

    public String getBookTitles() {
       return bookTitles;
    }
    
    public String getAuthors() {
       return authors;
    }

    public void setCity(String city) {
       this.city = city;
    }
}
