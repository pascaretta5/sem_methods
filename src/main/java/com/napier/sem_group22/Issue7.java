package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Author: Andrej Legen
 * Date: 15/04/22
 * Issue 7 method : get all cities in the world ordered from largest to smallest from the database.
 */

public class Issue7 {
    /**
     * -------------------------------Issue 7: getAllCitiesLargestToSmallest --------------
     *    Objective: get all cities in the world ordered from largest to smallest.
     *    Parameters: String region -- specified region.
     *    Return type: ArrayList<City>
     */
    public ArrayList<City> getAllCitiesLargestToSmallest(App app) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT city.name, country.name, district, city.population "
                            +"FROM city JOIN country ON CountryCode = Code "
                            + "ORDER BY city.population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

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
        //*  To place into main
        Issue7 iss7 = new Issue7();
        //call method to execute the query and get the population
        ArrayList<City> cities = iss7.getAllCitiesLargestToSmallest(a);
        //print Name and Population in console
        a.printCities(cities);
     */