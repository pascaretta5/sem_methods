package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author: Andrej
 * Date: 15/04/22
 * Issue 21 method : get the top N populated capital cities in a continent where N is provided by the user from the database.
 */

public class Issue21 {

    /**
     * -------------------------------Issue 21: getTopNIssue21 --------------
     *    Objective: The top N populated capital cities in a continent where N is provided by the user.
     *    @param N
     *    Return type: ArrayList<City>
     */
    public ArrayList<City> getTopNIssue21(String N, App app, String continent) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue21 =
                    "SELECT city.name, country.name, district, city.population "
                            + "FROM city JOIN country ON country.Capital = city.ID "
                            + "WHERE continent LIKE " + "'" + continent + "' "
                            + "ORDER BY city.population DESC "
                            + "LIMIT " + N;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue21);

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
/*
Issue21 issue21 = new Issue21();
ArrayList<City> cities = issue21.getTopNIssue21("1", a, "Europe");
a.printCities(cities);
*/