package databaseAccess;

import entity.*;
import java.sql.Connection;
import java.util.List;
import Interfaces.IBook;
import java.util.Map;

/**
 *q
 * @author Nexao
 */
public class MysqlControlFacade {

    public SQLDBMapper dbsql;
    public MongoDBMapper dbmongo;
    public SQLDBConnector dbcsql;
    public MongoDBConnector dbcmongo;
    private final Connection con;
    private static MysqlControlFacade instance;

    public MysqlControlFacade(){
        con = SQLDBConnector.getInstance().getConnection();
        dbsql = new SQLDBMapper();
    }


    public static MysqlControlFacade getInstance(){
        if (instance == null) {
            instance = new MysqlControlFacade();
        }
        return instance;
    }
      public Map<Long, IBook> getBooksByAuthor(String author) {
        return dbsql.getBooksByAuthor(author, con);
    }
      
    public Map<Long, IBook> getBooksByCityName(String cityName){
        return dbsql.getBooksByCityName(cityName, con);
    }
    
    public List<City> getCityByBookTitle(String book) {
        return dbsql.getCityByBookTitle(book, con);
    }
    
    public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius){
        return dbsql.getBooksInVicinity(lat, lng, radius, con);
    }

}
