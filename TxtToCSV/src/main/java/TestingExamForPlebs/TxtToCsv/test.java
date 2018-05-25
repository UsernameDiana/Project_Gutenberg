/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingExamForPlebs.TxtToCsv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author przyg
 */
public class test {

    public static void main(String[] args) {
        String text = "Small,Small,Small,Small,Small,Small,Small,Small,Small,Small,Small,Small";
        List<Set<String>> containingCities = new ArrayList<>();
        containingCities.add(new HashSet<>());
        String[] splited = text.split(",");
        for (String string : splited) {
            if(containingCities.get(0).contains(string))
            {
                System.out.println("Contains string");
            }
            else {
                containingCities.get(0).add(string);
            }
        }
        System.out.println(containingCities.get(0).size());
    }

}
