package databaseAccess;

import entity.*;
import java.sql.Connection;
import java.util.List;

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
        con = dbcsql.getInstance().getConnection();
        dbsql = new DBMapperSQL(dbcsql);
        dbmongo = new MongoDBMapper(dbcmongo);
    }

    public DBFacade(Connection conn) {
        con = conn;
        dbsql = new DBMapperSQL(dbcsql);
        dbmongo = new MongoDBMapper(dbcmongo);
    }

    public static DBFacade getInstance(){
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }
    
    public List<Book> getBooksByCityName(String cityName){
        return dbsql.getBooksByCityName(cityName);
    }

}
