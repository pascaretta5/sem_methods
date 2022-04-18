/**
 * Author: Andrei Vasiliu
 * Date: 25/03/2022
 * Issue 24: The population of people, people living in cities, and people not living in cities in each region.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Issue24 {

    // storing temporary data
    long regionPop = 0;
    float citiesPop = 0;

    /**
     *  ----- getIssue24() -------
     *  Objectives:
     *      return for each region the population of people,
     *      the percentage of the population living in cities,
     *      percentage NOT living in cities.
     *
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue24(App app) {

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
                    "SELECT SUM(country.Population), country.Region "
                            + "FROM country "
                            + "GROUP BY 2";

            String strIssue26b =
                    "SELECT SUM(city.Population), country.Region "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "GROUP BY country.Region";

            // Execute SQL statement and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue26);

            //Create Population ArrayList
            ArrayList<Population> populations = new ArrayList<Population>();

            while(rset.next()) {

                Population p = new Population();

                p.name = rset.getString(2);
                p.population = rset.getLong(1);
                populations.add(p);
            }

            ArrayList<Population> populations2 = new ArrayList<Population>();
            ResultSet rset2 = stmt.executeQuery(strIssue26b);
            while(rset2.next())
            {
                for(Population po : populations)
                {
                    if(Objects.equals(po.name, rset2.getString(2)))
                    {
                        Population p = new Population();
                        regionPop = po.population;
                        citiesPop = rset2.getFloat(1);
                        p.name = po.name;
                        p.population = po.population;
                        p.inCities = Math.round((citiesPop/regionPop*100)*100)/100d;
                        p.notinCities = 100d - Math.round((citiesPop/regionPop*100)*100)/100d;
                        populations2.add(p);
                    }
                }
            }

            return populations2;
        }
        catch (Exception e) //couldn't find region population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population (Issue 24)");
            return null;
        }
    }

}