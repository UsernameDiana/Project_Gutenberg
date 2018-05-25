package databaseAccess;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IBook;
import Interfaces.ICity;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import entity.Book;
import facade.BookFacade;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        SQLDBMapper sqlCon = new SQLDBMapper(new SQLDBConnector());

        //maybe
        //MongoDBMapper mongoCon = new MongoDBMapper(new MongoDBConnector());

        //maybe part2
//                try {
//                    MongoClient mongoClient = new MongoClient( "46.101.57.37" , 27017 );
//                    MongoDatabase db  = mongoClient.getDatabase( "gutenberg" );
//            System.out.println("Connected to mongo successfully!");
//                }catch(Exception e){
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//                } 
        Map<Long, IBook> bblist = new HashMap();
        List<IBook> blist = new ArrayList();


//        blist = sqlCon.getBooksByAuthorName("John Lord");
//        bblist = sqlCon.getBooksByCityName("Paris");


        System.out.println("------------ 1st Query");
        for (IBook iBook : blist) {
            System.out.println(iBook.getTitle());
        }

        System.out.println("------------ 2nd Query");

//        for (IBook iBook : bblist) {
//            System.out.println(iBook.getTitle());
//        }
    }

}
