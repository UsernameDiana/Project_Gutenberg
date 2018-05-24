package databaseAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Interfaces.IBook;
import Interfaces.IDataAccess;
import entity.Book;
import entity.City;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DBMapperSQL implements IDataAccess {

    private DBConnector sqlCon;

    public DBMapperSQL() {

    }

    public DBMapperSQL(DBConnector sqlCon) {
        this.sqlCon = sqlCon;
    }

    @Override
    public Map<Long, IBook> getBooksByCityName(String cityName, Connection con) {
        Map<Long, IBook> list = new HashMap();
        Set<Long> bookIds = new HashSet<>();

        try {
            
            Statement stmt = con.createStatement();
            
            String query = "SELECT DISTINCT b.bookid, tittle, city, name FROM Books b, Cities c, Authors a WHERE c.city = '" + cityName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Long bookid = Long.parseLong(res.getString("bookid")) ;
                String title = res.getString("tittle");
                String name = res.getString("name");
                System.out.println(bookid);
                if(bookIds.contains(bookid))
                {
                    IBook book = list.get(bookid);
                    book.addAuthor(name);
                }
                else {
                    IBook book = new Book(bookid, title, name);
                    System.out.println("testtestsetsetse");
                    list.put(bookid, book);
                    bookIds.add(bookid);
                }
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

    @Override
    public List<City> getCitiesByBookTitle(String bookTitle) {

        List<City> list = new ArrayList();

        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT DISTINCT * FROM Books b INNER JOIN Cities c  WHERE b.tittle = '" + bookTitle + "' AND b.bookid = c.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String city = res.getString("city");
                list.add(new City(city));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

    @Override
    public List<IBook> getBooksByAuthorName(String authorName) {

        List<IBook> list = new ArrayList();

        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT DISTINCT * FROM Books b INNER JOIN Authors a  WHERE a.name = '" + authorName + "' AND b.bookid = a.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String title = res.getString("tittle");
                list.add(new Book(title, authorName));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

//	public List<Nodes> getAll() {
//		List<Nodes> list = new ArrayList();
//
//		try {
//			Connection connection = this.sqlCon.getConnection();
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM Nodes";
//			ResultSet res = stmt.executeQuery(query);
//			list = this.getResults(res);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		return list;
//	}
//
//	
//
//	public List<Nodes> depthTwo(String name) {
//		List<Nodes> list = new ArrayList();
//		try {
//			Connection connection = this.sqlCon.getConnection();
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
//					+ name + "')) LIMIT 5;";
//			ResultSet res = stmt.executeQuery(query);
//			list = this.getResults(res);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		return list;
//	}
//
//	public List<Nodes> depthThree(String name) {
//		List<Nodes> list = new ArrayList();
//		try {
//			Connection connection = this.sqlCon.getConnection();
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
//					+ name + "'))) LIMIT 5;";
//			ResultSet res = stmt.executeQuery(query);
//			list = this.getResults(res);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		return list;
//	}
//
//	public List<Nodes> depthFour(String name) {
//		List<Nodes> list = new ArrayList();
//		try {
//			Connection connection = this.sqlCon.getConnection();
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
//					+ name + "')))) LIMIT 5;";
//			ResultSet res = stmt.executeQuery(query);
//
//			list = this.getResults(res);
//
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		return list;
//	}
//
//	public List<Nodes> depthFive(String name) {
//		List<Nodes> list = new ArrayList();
//		try {
//			Connection connection = this.sqlCon.getConnection();
//			Statement stmt = connection.createStatement();
//			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
//					+ name + "'))))) LIMIT 5;";
//			ResultSet res = stmt.executeQuery(query);
//
//			list = this.getResults(res);
//
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		return list;
//	}
//
////	public Nodes getRandom(int id) {
////		Nodes p = null;
////
////		try {
////			Connection connection = this.sqlCon.getConnection();
////			Statement stmt = connection.createStatement();
////			String query = "SELECT * FROM Nodes WHERE id ='" + id + "' ";
////			ResultSet res = stmt.executeQuery(query);
////			while (res.next()) {
////				String name = res.getString("name");
////				String job = res.getString("job");
////				String bday = res.getString("birthday");
////				p = new Nodes(id + "", name, job, bday);
////			}
////		} catch (Exception e) {
////			System.out.println(e.toString());
////		}
////		return p;
////	}
//	
//	private List<Nodes> getResults(ResultSet res) throws SQLException {
//		List<Nodes> list = new ArrayList();
//		while (res.next()) {
//			String id = res.getString("id");
//			String name = res.getString("name");
//			String job = res.getString("job");
//			String bday = res.getString("birthday");
//			Nodes p = new Nodes(id, name, job, bday);
//			list.add(p);
//		}
//		return list;
//	}
}
