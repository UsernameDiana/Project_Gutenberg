package databaseAccess;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author diana
 */
public class MongoDBConnector {

    private MongoClient mongoClient = null;

    private String URI = "mongodb://place your mongodb access here";

    public MongoClient getConnection() {
        try {
            this.mongoClient = new MongoClient(new MongoClientURI(URI));

        } catch (Exception e) {
            System.out.println("ERROR IN MONGODB CONNECTION" + e.toString());
        }

        return this.mongoClient;
    }

    public void close() {
        this.mongoClient.close();
    }

}
