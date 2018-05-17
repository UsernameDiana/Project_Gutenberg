package databaseAccess;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IBook;
import Interfaces.ICity;

public class Main {

	public static void main(String[] args) throws Exception {
		DBMapperSQL sqlCon = new DBMapperSQL(new DBConnector());
		List<IBook> bblist = new ArrayList();
		List<IBook> blist = new ArrayList();
		
		blist = sqlCon.getBooksByAuthorName("Joseph Conrad");
		bblist = sqlCon.getBooksByCityName("That");
		
		for (IBook iBook : blist) {
			System.out.println(iBook.getTitle());
		}
		
		System.out.println("-----------------");
		
		for (IBook iBook : bblist) {
			System.out.println(iBook.getTitle());
		}
	}

}
