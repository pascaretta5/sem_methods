/**
 * Author: Andrei Vasiliu
 * Date: 15/04/2022
 * Issue 23: The population of people, people living in cities, and people not living in cities in each continent.
 * */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Issue23 {

    // storing temporary data
    long continentPop = 0;
    float citiesPop = 0;

    /**
     *  ----- getIssue24() -------
     *  Objectives:
     *      return for each continent the population of people,
     *      the percentage of the population living in cities,
     *      percentage NOT living in cities.
     *
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue23(App app) {

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
                    "SELECT SUM(country.Population), country.Continent "
                            + "FROM country "
                            + "GROUP BY 2";

            String strIssue26b =
                    "SELECT SUM(city.Population), country.Continent "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "GROUP BY 2";

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
                        continentPop = po.population;
                        citiesPop = rset2.getFloat(1);
                        p.name = po.name;
                        p.population = po.population;
                        p.inCities = Math.round((citiesPop/continentPop*100)*100)/100d;
                        p.notinCities = 100d - Math.round((citiesPop/continentPop*100)*100)/100d;
                        populations2.add(p);
                    }
                }
            }

            return populations2;
        }
        catch (Exception e) //couldn't find continent population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population (Issue 23)");
            return null;
        }
    }

}