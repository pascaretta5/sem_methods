/**
 * Author: Andrei Vasiliu
 * Date: 25/03/2022
 * Issue 28: The population of a region.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue28 {

    // storing temporary data
    long regionPop = 0;
    float citiesPop = 0;

    /**
     *  ----- getIssue28() -------
     *  Objectives:
     *      return the population of a region,
     *      the percentage of the population living in cities,
     *      percentage NOT living in cities.
     *
     * @param region
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue28(App app, String region)
    {

        try
        {
            // Check for missing parameters
            if (app == null && region == null)
            {
                System.out.println("'app' and 'region' parameters are missing");
                return null;
            } else if (region == null)
            {
                System.out.println("'Region' parameter is missing");
                return null;
            } else if (app == null)
            {
                System.out.println("'app' parameter is missing");
                return null;
            }
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue28 =
                    "SELECT SUM(country.Population) "
                            + "FROM country "
                            + "WHERE country.Region=" + "'" + region + "' ";

            String strIssue28b =
                    "SELECT SUM(city.Population) "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Region=" + "'" + region + "' ";

            // Execute SQL statement and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue28);
            rset.next();
            regionPop = rset.getInt(1);

            ResultSet rset2 = stmt.executeQuery(strIssue28b);
            rset2.next();
            citiesPop = rset2.getFloat(1);

            //Creating Population ArrayList
            ArrayList<Population> p = new ArrayList<Population>();
            //Formatting data and storing it
            Population po = new Population();
            po.name = region;
            po.population = regionPop;
            po.inCities = citiesPop/regionPop*100;
            po.notinCities = 100 - (citiesPop/regionPop*100);
            p.add(po);
            //calling print function
            return p;
        }
        catch (Exception e) //couldn't find region population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population (Issue 28)");
            return null;
        }
    }

}