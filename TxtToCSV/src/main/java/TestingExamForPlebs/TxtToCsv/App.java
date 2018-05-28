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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        List<Set<String>> containingCities = new ArrayList<>();
        int bookID = 0;
        ReadCities read = new ReadCities();
        Map<String, ListCity> listedCities = read.list();
        List<File> filesInFolder = Files
                .walk(Paths.get("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads"))
                .filter(p -> p.getFileName().toString().endsWith(".txt")).map(Path::toFile)
                .collect(Collectors.toList());
        containingCities.add(new HashSet<>());
        for (File file : filesInFolder) {
            // This will reference one line at a time
            String line = null;
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(file);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                boolean titleNotFound = false;
                boolean titleFound = false;
                boolean nameNotFound = false;
                boolean nameFound = false;
                while ((line = bufferedReader.readLine()) != null) {

                    if (!headerIsFinished) {
                        if (line.contains("Title: ")) {
                            String[] list = line.split(": ");
                            String name = list[1].replaceAll("[^a-zA-Z0-9 ]", "");
                            if (!bufferedReader.readLine().replaceAll("[^a-zA-Z0-9 ]", "").equals("")) {
                                name += " " + bufferedReader.readLine().replaceAll("[^a-zA-Z0-9 ]", "");
                            }
                            titleFound = true;
                            bookList.add(new Book(name, bookID));
                        } else {
                            titleNotFound = true;
                        }
                        if (line.contains("Author: ")) {
                            nameFound = true;
                            String[] list = line.split(": ");
                            list[1] = list[1].replaceAll("[^a-zA-Z0-9 ]", "");
                            String[] newList = list[1].split(" and ");
                            for (String string : newList) {
                                authorList.add(new Author(string, bookID));
                            }
                        } else {
                            nameNotFound = true;
                        }
                    }

                    if ((line.contains("*** START") || line.contains("***START")) && !headerIsFinished) {
                        headerIsFinished = true;
                        if (titleNotFound && !titleFound) {
                            bookList.add(new Book("TitleNotFound-" + bookID, bookID));
                        }
                        if (nameNotFound && !nameFound) {
                            authorList.add(new Author("NameNotFound-" + bookID, bookID));
                        }
                    }

                    if (headerIsFinished) {
                        line = line.replaceAll("[^a-zA-Z0-9 ]", "");
                        String[] words = line.split(" ");
                        for (String string : words) {
                            if (string.length() > 3) {
                                if (Character.isUpperCase(string.charAt(0))
                                        && Character.isLowerCase(string.charAt(1))) {
                                    if (listedCities.containsKey(string)) {
                                        if (!containingCities.get(bookID).contains(string)) {
                                            cityList.add(new City(string, bookID, listedCities.get(string).getLatitude(), listedCities.get(string).getLongitude()));
                                            containingCities.get(bookID).add(string);
                                        }
                                    }
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
            containingCities.add(new HashSet<>());
            bookID++;
            headerIsFinished = false;
        }

        FileWriter fw = new FileWriter("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads\\Books.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("bookid,title,");
        bw.newLine();
        for (Book book : bookList) {

            bw.write(book.bookID + "," + book.title);
            bw.newLine();
        }
        bw.close();
        fw = new FileWriter("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads\\Authors.csv", true);
        bw = new BufferedWriter(fw);
        bw.write("name,bookid,");
        bw.newLine();
        for (Author author : authorList) {

            bw.write(author.name + "," + author.bookID);
            bw.newLine();
        }
        bw.close();
        fw = new FileWriter("C:\\Users\\przyg\\Downloads\\soft\\soft\\book_download\\Downloads\\Cities.csv", true);
        bw = new BufferedWriter(fw);
        bw.write("city,bookid,latitude,longitude");
        bw.newLine();
        for (City city : cityList) {

            bw.write(city.name + "," + city.bookID + "," + city.latitude + "," + city.longitude);
            bw.newLine();
        }
        bw.close();

    }

}
