package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Author: Bruno Pascaretta Guerra
 * Date: 28/04/22
 * Purpose:
 * Return the top N populated capital cities in a region where N is provided by the user
 */


public class Issue22 {
    /**
     * --------------------Issue #22: All the top N populated capital cities in a region where N is provided by the user--------
     *    Objective: get all N top populated capital cities in a region.
     *    @param region
     *    @param limit
     *    @return  ArrayList<City> = return an array list with all the cities
     */
    public ArrayList<City> getTopCapitalsRegion(App app, String region, Integer limit) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement

            //Needed to join both table CITY and COUNTRY in order to retrieve the right capital.
            String strPopulationLageSmall =
                    "SELECT country.Region, country.Name, city.Name, city.Population, city.District "
                            + "FROM city JOIN country ON CountryCode = Code "
                            + "WHERE country.capital = city.ID AND Region LIKE '" + region +"' "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + limit + "; ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create city ArrayList
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned and go through all cities and to get the details
            while (rset.next())
            {
                City city= new City();

                city.population = rset.getInt("city.Population");
                city.name = rset.getString("city.Name");
                city.district = rset.getString("city.District");
                city.countryName = rset.getString("country.Name");
                cities.add(city); // add city in ArrayList<City> cities
            }
            return cities; // return ArrayList
        }
        catch (Exception e) //no city found
        {

            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities population");
            return null;
        }
    }
}
