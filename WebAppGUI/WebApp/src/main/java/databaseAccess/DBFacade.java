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
public class DBFacade {

    public DBMapperSQL dbsql;
    public MongoDBMapper dbmongo;
    public DBConnector dbcsql;
    public MongoDBConnector dbcmongo;
    private final Connection con;
    private static DBFacade instance;

    public DBFacade(){
        con = DBConnector.getInstance().getConnection();
        dbsql = new DBMapperSQL();
    }


    public static DBFacade getInstance(){
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }
    
    public Map<Long, IBook> getBooksByCityName(String cityName){
        return dbsql.getBooksByCityName(cityName, con);
    }

}
