package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author: Andrej Legen
 * Date: 20/04/22
 * Purpose:
 * Get all the top N populated cities in the world where N is provided by the user.
 */

public class Issue12 {

    /**
     * ------------ getTopNIssue12 ---------------
     * .
     * @param app = get the app class instance for connection
     * @param N = specifies number of results shown
     * @return  ArrayList<City> = return an array list with all the cities
     * purpose = Get all the top N populated cities in the world where N is provided by the user.
     */

    public ArrayList<City> getTopNIssue12(String N, App app) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue12 =
                    "SELECT city.name, country.name, district, city.population "
                            +"FROM city JOIN country ON country.Capital = city.ID "
                            + "ORDER BY city.population DESC "
                            + "LIMIT " + N + ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue12);

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

//*  To place into main
//** Create instance of Issue12 Class-- this will have the required methods */
//Issue12 issue12 = new Issue12();
//ArrayList<City> cities = issue12.getIssue12(a);
// /** Print countries and column names */
// a.printCity(cities);
