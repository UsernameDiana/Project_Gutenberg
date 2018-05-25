/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingExamForPlebs.TxtToCsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author przyg
 */
public class ReadCities {

    public ReadCities() {
        
    }
    
    public Map<String, ListCity> list(){
        Map<String, ListCity> cities  = new HashMap<>();
        int bookID = 0;
        File file = new File("C:\\Users\\przyg\\Downloads\\worldcitiespop.txt\\List.txt");
                

        
            // This will reference one line at a time
            String line = null;
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(file);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(",");
                    cities.put(words[0], new ListCity(words[0], Double.parseDouble(words[1]), Double.parseDouble(words[2])));
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        return cities;    
    }
    
}
