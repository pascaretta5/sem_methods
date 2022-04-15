/**
 * Author: Sara
 * Date: 22/02/22
 * Issue 6 methods : The top N populated countries in a region where N is provided by the user.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue6 {



    /**
     *  ----- getNTopPopCountriesRegion() -------
     *  Objective: return N top populated countries in a region, where N is given by the user
     * @param N
     * @return  ArrayList<Country>
     */
    public ArrayList<Country> getNTopPopCountriesRegion(String N, App app, String region) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue6 =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country JOIN city ON country.Capital = city.ID "
                            + "WHERE Region LIKE '" + region +"' "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + N + "; ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue6);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();


                count.code = rset.getString("Code");
                count.population = rset.getInt("Population");
                count.name = rset.getString("Name");
                count.continent = rset.getString("Continent");
                count.region = rset.getString("Region");
                count.capitalName = rset.getString("city.Name");
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
