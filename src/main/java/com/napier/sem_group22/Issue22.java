package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue22 {
    /**
     * --------------------Issue #22: All the top N populated capital cities in a region where N is provided by the user--------
     *    Objective: get all N top populated capital cities in a region.
     *    @param region
     *    @param limit
     *    @return ArrayList<Country>
     */
    public ArrayList<Country> getTopCapitalsRegion(App app, String region, Integer limit) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement

            //Needed to join both table CITY and COUNTRY in order to retrieve the right capital.
            String strPopulationLageSmall =
                    "SELECT country.Region, country.Population, city.Name "
                            + "FROM city JOIN country ON CountryCode = Code "
                            + "WHERE country.capital = city.ID AND Continent LIKE '" + region +"' "
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
                count.region = rset.getString("country.Region");
                count.capitalName = rset.getString("city.Name");
                count.population = rset.getInt("country.Population");
                countries.add(count); // add country in ArrayList<Country> countries
            }
            return countries; // return ArrayList
        }
        catch (Exception e) //no country found
        {

            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities population");
            return null;
        }
    }
}
