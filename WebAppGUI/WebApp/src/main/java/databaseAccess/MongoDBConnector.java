package databaseAccess;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Zygi and Emil
 */
public class MongoDBConnector {

    private MongoClient mongoClient = null;
    MongoDatabase db = null;

    public MongoDatabase getDatabase() {
        try {

            mongoClient = new MongoClient(new ServerAddress("46.101.57.37", 27017));
            db = mongoClient.getDatabase("gutenberg");

        } catch (Exception e) {
            System.out.println("ERROR IN MONGODB CONNECTION" + e.toString());
        }

        return db;
    }

    public void close() {
        this.mongoClient.close();
    }

}
