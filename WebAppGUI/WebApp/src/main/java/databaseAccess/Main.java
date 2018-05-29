package databaseAccess;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws Exception {

//        SQLDBMapper sqlCon = new SQLDBMapper(new SQLDBConnector());
//        MongoDBConnector con = new MongoDBConnector();
//        MongoDatabase mongodb = con.getDatabase();
//        MongoDBMapper mMap = new MongoDBMapper();
        PostgDBConnector postgconn = new PostgDBConnector();
        Connection con = postgconn.getConnection();
        PostgDBMapper postgCon = new PostgDBMapper();
        
        System.out.println("books" + postgCon.getBooksByCityName("Paris", con));
        
        
//        MongoCollection<Document> collection = mongodb.getCollection("books");

//        BasicDBObject searchQuery = new BasicDBObject();
//        searchQuery.put("title", "Within the Tides");
//        System.out.println("Books: " + mMap.getBooksByAuthorName("Herbert George Wells"));
//        System.out.println("Books: " + mMap.getBooksByAuthorName("Anonymous"));
//        System.out.println("Cities: " + mMap.getCitiesByBookTitle("Apocolocyntosis"));

//        MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }

    }

}
