/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingExamForPlebs.TxtToCsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
 *
 * @author przyg
 */
public class Cities {

    public static void main(String[] args) throws IOException {
        //Country,City,AccentCity,Region,Population,Latitude,Longitude
        // The name of the file to open.
        List<String> city  = new ArrayList<>();
        int bookID = 0;
        File file = new File("C:\\Users\\przyg\\Downloads\\worldcitiespop.txt\\worldcitiespop.txt");
                

        
            // This will reference one line at a time
            String line = null;
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(file);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(",");
                    String newLine = words[2] + "," + words[5]+ "," + words[6];
                    city.add(newLine);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            
            FileWriter fw = new FileWriter("C:\\Users\\przyg\\Downloads\\worldcitiespop.txt\\List.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    for (int i = 0; i < city.size(); i++) {

		    bw.write(city.get(i));
		    bw.newLine();
		}
	    bw.close();
        }
    }

