package databaseAccess;

import entity.*;
import java.sql.Connection;

/**
 *
 * @author Nexao
 */
public class DBFacade {

    public DBMapperSQL dbsql;
    public MongoDBMapper dbmongo;
    public DBConnector dbcsql;
    public MongoDBConnector dbcmongo;
    private final Connection con;
    private static DBFacade instance;

    public DBFacade() throws Exception {
        con = dbcsql.getInstance().getConnection();
        dbsql = new DBMapperSQL(dbcsql);
        dbmongo = new MongoDBMapper();
    }

    public DBFacade(Connection conn) {
        con = conn;
        dbsql = new DBMapperSQL(dbcsql);
        dbmongo = new MongoDBMapper();
    }

    public static DBFacade getInstance() throws Exception {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }

}
