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

    public SQLDBMapper dbsql;
    public MongoDBMapper dbmongo;
    public SQLDBConnector dbcsql;
    public MongoDBConnector dbcmongo;
    private final Connection con;
    private static DBFacade instance;

    public DBFacade(){
        con = SQLDBConnector.getInstance().getConnection();
        dbsql = new SQLDBMapper();
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
