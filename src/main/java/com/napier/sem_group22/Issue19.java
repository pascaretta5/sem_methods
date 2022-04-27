/**
 * Author: Andrej
 * Date: 22/02/22
 * Issue 19
 */

package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author: Andrej
 * Date: 15/04/22
 * Issue 19 method : get the top N populated capital cities in the world where N is provided by the user from the database.
 */

public class Issue19 {

    /**
     * -------------------------------Issue 19: getIssue19 --------------
     *    Objective: The top N populated capital cities in the world where N is provided by the user.
     *    Return type: ArrayList<Country>
     */
    public ArrayList<City> getIssue19(String N, App app) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue19 =
                    "SELECT city.name, country.name, district, city.population "
                            +"FROM city JOIN country ON country.Capital = city.ID "
                            + "ORDER BY country.region, city.population DESC "
                            + "LIMIT " + N + ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue19);

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
Issue19 issue19 = new Issue19();
ArrayList<City> cities = issue19.getIssue19("1", a);
a.printCities(cities);
*/