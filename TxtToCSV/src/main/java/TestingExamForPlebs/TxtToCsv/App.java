package TestingExamForPlebs.TxtToCsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
	private static boolean headerIsFinished = false;
	private static ArrayList<Author> authorList = new ArrayList<Author>();
	private static ArrayList<Book> bookList = new ArrayList<Book>();
	private static ArrayList<City> cityList = new ArrayList<City>();

	public static void main(String[] args) throws IOException {
		// The name of the file to open.
		int bookID = 0;
		List<File> filesInFolder = Files
				.walk(Paths.get("/Users/diana/Desktop/git/Project_Gutenberg/TxtToCSV/booksfortesting"))
				.filter(p -> p.getFileName().toString().endsWith(".txt")).map(Path::toFile)
				.collect(Collectors.toList());

		for (File file : filesInFolder) {
			// This will reference one line at a time
			String line = null;
			try {
				// FileReader reads text files in the default encoding.
				FileReader fileReader = new FileReader(file);

				// Always wrap FileReader in BufferedReader.
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				
				while ((line = bufferedReader.readLine()) != null) {
					
					if (!headerIsFinished) {
						if (line.contains("Title: ")) {
							String[] list = line.split(": ");
							String name = list[1].replaceAll("[^a-zA-Z0-9 ]", "");
							bookList.add(new Book(name, bookID));
						} 
						if (line.contains("Author: ")) {
							String[] list = line.split(": ");
							authorList.add(new Author(list[1], bookID));
						}
					}
					
					if ((line.contains("*** START") || line.contains("***START")) && !headerIsFinished) {
						headerIsFinished = true;
					}
					
					if (headerIsFinished) {
						line = line.replaceAll("[^a-zA-Z0-9 ]", "");
						String[] words = line.split(" ");
						for (String string : words) {
							if (string.length() > 3) {
								if (Character.isUpperCase(string.charAt(0))
										&& Character.isLowerCase(string.charAt(1))) {
									cityList.add(new City(string, bookID));
								}
							}
						}
					}
				}

				// Always close files.
				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + file + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + file + "'");
				// Or we could just do this:
				// ex.printStackTrace();
			}
			bookID++;
			headerIsFinished = false;
		}
		
		FileWriter fw = new FileWriter("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads\\Books.csv", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write("bookid,title,");
	    bw.newLine();
	    for (Book book : bookList) {

		    bw.write(book.bookID +","+book.title+",");
		    bw.newLine();
		}
	    bw.close();
	    fw = new FileWriter("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads\\Authors.csv", true);
	    bw = new BufferedWriter(fw);
	    bw.write("name,bookid,");
	    bw.newLine();
	    for (Author author : authorList) {

		    bw.write(author.name +","+author.bookID+",");
		    bw.newLine();
		}
	    bw.close();
	    fw = new FileWriter("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads\\Cities.csv", true);
	    bw = new BufferedWriter(fw);
	    bw.write("city,bookid,");
	    bw.newLine();
	    for (City city : cityList) {

		    bw.write(city.name +","+city.bookID+",");
		    bw.newLine();
		}
	    bw.close();

	}

}
