/**
 * Author: Andrei Vasiliu
 * Date: 25/03/2022
 * Issue 25: The population of people, people living in cities, and people not living in cities in each country.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Issue25 {

    // storing temporary data
    long countryPop = 0;
    float citiesPop = 0;

    /**
     *  ----- getIssue25() -------
     *  Objectives:
     *      return for each country the population of people,
     *      the percentage of the population living in cities,
     *      percentage NOT living in cities.
     *
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue25(App app) {

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
            String strIssue25 =
                    "SELECT SUM(country.Population), country.Name "
                            + "FROM country "
                            + "GROUP BY country.Name";

            String strIssue25b =
                    "SELECT SUM(city.Population), country.Name "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "GROUP BY country.Name";

            // Execute SQL statement and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue25);

            //Create Population ArrayList
            ArrayList<Population> populations = new ArrayList<Population>();

            while(rset.next()) {

                Population p = new Population();

                p.name = rset.getString(2);
                p.population = rset.getLong(1);
                populations.add(p);
            }

            ArrayList<Population> populations2 = new ArrayList<Population>();
            ResultSet rset2 = stmt.executeQuery(strIssue25b);
            while(rset2.next())
            {
                for(Population po : populations)
                {
                    if(Objects.equals(po.name, rset2.getString(2)))
                    {
                        Population p = new Population();
                        countryPop = po.population;
                        citiesPop = rset2.getFloat(1);
                        p.name = po.name;
                        p.population = po.population;
                        p.inCities = citiesPop/countryPop*100;
                        p.notinCities = 100-(citiesPop/countryPop*100);
                        populations2.add(p);
                    }
                }
            }

            return populations2;
        }
        catch (Exception e) //couldn't find countries population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population (Issue 25)");
            return null;
        }
    }

}