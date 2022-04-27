package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue27 {
    // storing temporary data
    long regionPop = 0;
    float citiesPop = 0;
    /**
     *  ----- getIssue27() -------
     *  Objectives:
     *      return the population of a continent.
     *
     * @param continent
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue27(App app, String continent)
    {

        try
        {
            // Check for missing parameters
            if (app == null && continent == null)
            {
                System.out.println("'app' and 'continent' parameters are missing");
                return null;
            } else if (continent == null)
            {
                System.out.println("'continent' parameter is missing");
                return null;
            } else if (app == null)
            {
                System.out.println("'app' parameter is missing");
                return null;
            }


            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            String strIssue27 =
                    "SELECT SUM(country.Population) "
                            + "FROM country "
                            + "WHERE country.continent =" + "'" + continent + "'";
            String strIssue27b =
                    "SELECT SUM(city.Population) "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.continent =" + "'" + continent + "'";



            // Execute SQL statements and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue27);
            rset.next();
            regionPop = rset.getLong(1);

            ResultSet rset2 = stmt.executeQuery(strIssue27b);
            rset2.next();
            citiesPop = rset2.getFloat(1);

            //Creating Population ArrayList
            ArrayList<Population> p = new ArrayList<Population>();
            //Formatting data and storing it
            Population po = new Population();
            po.name = continent;
            po.population = regionPop;
            po.CityPop = rset2.getLong(1);
            po.notINCityPop = regionPop - rset2.getLong(1);
            po.inCities = Math.round((citiesPop/regionPop*100)*100)/100d;
            po.notinCities = 100d - Math.round((citiesPop/regionPop*100)*100)/100d;
            p.add(po);


            return p;
        }
        catch (Exception e) //couldn't find continent population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population (Issue 27)");

            return null;
        }
    }
}

