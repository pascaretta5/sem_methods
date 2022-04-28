package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author: Sara
 * Class to get the issue 4 data from the database
 */
public class Issue4 {
    /**
     * -------------------------------------- Issue #4 functions --------------------------------------
     * ----------- getThreeBiggestCountries(String N) ---------------
     *     Objective: get the N countries with the biggest population from each continent.
     *     @param N: Snumber of countries from each continent.
     *     Return type: ArrayList<Country>
     */
    public ArrayList<Country> getNBiggestCountries(App app, String N) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strThreeBiggestPopByCont =
                    "SELECT x.Code, x.Population, x.Continent, x.Name, x.Region, city.Name "
                            +"FROM country x  JOIN city ON x.Capital = city.ID " +
                            "WHERE x.name IN (SELECT * FROM (SELECT y.Name FROM country y WHERE y.Continent = x.Continent ORDER BY Population DESC LIMIT " + N + ") z) ORDER BY x.Continent;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strThreeBiggestPopByCont);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();


                count.code = rset.getString("Code");
                count.population = rset.getInt("Population");
                count.name = rset.getString("Name");
                count.continent = rset.getString("Continent");
                count.region = rset.getString("Region");
                count.capitalName = rset.getString("city.Name");
                countries.add(count); // add country in ArrayList<Country> countries
            }
            return countries; // return ArrayList
        }
        catch (Exception e) //no country found
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population");
            return null;
        }
    }
    /*
        Issue4 iss4 = new Issue4();
        //call method to execute the query and get the population
        ArrayList<Country> countries = iss4.getNBiggestCountries(a, "2");
        //print Name and Population in console
        a.printCountries(countries);
     */
}
