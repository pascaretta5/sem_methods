package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue1 {
    /**
     * ---------------------------------------Issue #1-------------------------
     *    ----------- getCountryPopulationLargeToSmall() ---------------
     *    Objective: get all the countries population from largest to smallest.
     *    @return ArrayList<Country> countries -- list of countries to be printed
     */

    public ArrayList<Country> getCountryPopulationLargeToSmall(App app) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT Code, country.Population, Continent, country.Name, Region, city.Name "
                            +"FROM country JOIN city ON country.Capital = city.ID "
                            + "ORDER BY Population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned
            while (rset.next())
            {
                Country count = new Country();
                count.name = rset.getString("Name");
                count.population = rset.getInt("Population");
                count.code = rset.getString("Code");
                count.continent = rset.getString("Continent");
                count.region = rset.getString("Region");
                count.capitalName = rset.getString("city.Name");

                countries.add(count);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population");
            return null;
        }
    }

}
