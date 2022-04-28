package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Author: Bruno Pascaretta Guerra
 * Date: 28/04/22
 * Purpose:
 * Return the top N populated countries in a continent where N is provided by the user.
 */


public class Issue5 {
    /**
     * --------------------Issue #5: All the top N countries in a continent where N is provided by the user--------
     *    Objective: get all N top populated countries in continents -- Large to Small.
     *    @param continent
     *    @param limit
     *    @return ArrayList<Country>
     */
    public ArrayList<Country> getTopCountryByContinentLargeToSmall(App app, String continent, Integer limit) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement

            //Needed to join both table CITY and COUNTRY in order to retrieve the right capital.
            String strPopulationLageSmall =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM city JOIN country ON CountryCode = Code "
                            + "WHERE country.capital = city.ID AND Continent LIKE '" + continent +"' "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + limit + "; ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries and to get the details
            while (rset.next())
            {
                Country count = new Country();
                count.code = rset.getString("country.Code");
                count.region = rset.getString("country.Region");
                count.capitalName = rset.getString("city.Name");
                count.continent = rset.getString("country.Continent");
                count.name = rset.getString("country.Name");
                count.population = rset.getInt("country.Population");
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
}
