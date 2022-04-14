/**
 * Author: Andrei Vasiliu
 * Date: 25/03/2022
 * Issue 26: The population of the entire world.
 */
package com.napier.sem_group22;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue26 {

    // storing temporary data
    long worldPop = 0;
    double citiesPop = 0;

    /**
     *  ----- getIssue26() -------
     *  Objectives:
     *      return the population of the world,
     *      the percentage of the world population living in cities,
     *      percentage NOT living in cities.
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue26(App app) {

        try
        {
            // Check for missing parameters
            if (app == null)
            {
                System.out.println("'app' parameter is missing");
                return null;
            }
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue26 =
                    "SELECT SUM(country.Population), "
                            + "(SELECT SUM(city.Population) FROM city)"
                            + "FROM country " ;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue26);

            // Extrapolate the values from columns
            rset.next();
            worldPop = rset.getLong(1);
            citiesPop = rset.getDouble(2);

            ArrayList<Population> population = new ArrayList<Population>();
            Population p = new Population();
            p.name = "Entire wolrld";
            p.population = worldPop;
            p.inCities = citiesPop/worldPop*100;
            p.notinCities = 100 - (citiesPop/worldPop*100);
            population.add(p);

            return population;

        }
        catch (Exception e) //couldn't find world population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population (Issue 26)");
            return null;
        }
    }

}
