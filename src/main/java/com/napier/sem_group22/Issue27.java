package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue27 {
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
            continent = "North America";
            String strIssue27 =
                    "SELECT SUM(Population) "
                            + "FROM country "
                            + "WHERE continent =" + "'" + continent + "'";

            // Execute SQL statement and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue27);
            rset.next();


            //Creating Population ArrayList
            ArrayList<Population> p = new ArrayList<Population>();
            //Formatting data and storing it
            Population po = new Population();
            po.name = continent;
            po.population = rset.getLong(1);
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

