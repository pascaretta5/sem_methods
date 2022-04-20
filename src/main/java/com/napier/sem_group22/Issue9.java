package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author: Sara Hussein Celda
 * Date: 15/04/22
 * Purpose:
 * Get all the cities in a region organised by largest population to smallest.
 */
public class Issue9 {
    /**
     * ------------ getCitiesLargeSmallPopRegion ---------------
     * .
     * @param app = get the app class instance for connection
     * @param region = specified region to get cities from
     * @return  ArrayList<City> = return an array list with all the cities
     * purpose = get all the cities and their populations from largest to smallest on a specific
     *           region.
     */
    public ArrayList<City> getCitiesLargeSmallPopRegion(App app, String region) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue9 =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Region LIKE '" + region +"' "
                            + "ORDER BY Population DESC ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue9);

            //Create cities ArrayList
            ArrayList<City> cities= new ArrayList<City>();

            // Check one is returned and go through all cities to get the details
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
            System.out.println("Failed to get cities population");
            return null;
        }
    }

    /*
      Code to add in App.java main method to call this Issue9 method -->

              Issue9 is9 = new Issue9();
              ArrayList<City> cities = is9.getCitiesLargeSmallPopRegion(a, "Caribbean");
              a.printCities(cities);
     */

}
