/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nexao
 */
public class TestPopulateDatabase {

    private static final String FILENAME = "C:\\Users\\Nexao\\Documents\\NetBeansProjects\\Project_Gutenberg\\WebAppGUI\\WebApp\\src\\test\\java\\databaseAccess\\Testdb.sql";

    private LocalConnection sqlCon;

    public TestPopulateDatabase(LocalConnection sqlCon) {
        this.sqlCon = sqlCon;
    }

    public void populate() throws SQLException {

        BufferedReader br = null;
        FileReader fr = null;

        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                String query = sCurrentLine;
                stmt.executeQuery(query);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}
