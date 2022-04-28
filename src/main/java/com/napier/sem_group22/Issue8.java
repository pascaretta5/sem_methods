package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Author: Sara Hussein Celda
 * Date: 15/04/22
 * Purpose:
 * Get all the cities in a continent organised by largest population to smallest.
 */


public class Issue8 {

    /**
     * ------------ getCitiesLargeSmallPop ---------------
     * .
     * @param app = get the app class instance for connection
     * @param continent = specified continent to get cities from
     * @return  ArrayList<City> = return an array list with all the cities
     * purpose = get all the cities and their populations from largest to smallest on a specific
     *           continent.
     */
    public ArrayList<City> getCitiesLargeSmallPop(App app, String continent) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue8 =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Continent LIKE '" + continent +"' "
                            + "ORDER BY Population DESC ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue8);

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
      Code to add in App.java main method to call this Issue8 method -->

              Issue8 is8 = new Issue8();
              ArrayList<City> cities = is8.getCitiesLargeSmallPop(a, "Europe");
              a.printCities(cities);
     */
}
