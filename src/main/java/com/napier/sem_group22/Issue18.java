package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue18 {

    /**
     * -------------------------------Issue 18: getIssue18 --------------
     *    Objective: All the capital cities in a continent organised by largest population to smallest.
     *    Return type: ArrayList<Country>
     */
    public ArrayList<City> getIssue18(App app) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue18 =
                    "SELECT city.name, country.name, district, city.population "
                            +"FROM city JOIN country ON country.Capital = city.ID "
                            + "ORDER BY Continent, city.population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue18);

            //Create Country ArrayList
            ArrayList<City> cities = new ArrayList<City>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                City acity = new City();
                acity.name = rset.getString("city.name");
                acity.countryName = rset.getString("country.name");
                acity.district = rset.getString("district");
                acity.population = rset.getInt("city.population");
                cities.add(acity); // add country in ArrayList<Country> countries

            }
            return cities; // return ArrayList
        }
        catch (Exception e) //no country found
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population");
            return null;
        }
    }

}
