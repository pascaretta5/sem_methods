package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue31 {
    /**
     *  ----- getIssue31() -------
     *  Objectives:
     *      return the population of a city.
     *
     * @param city
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue31(App app, String city)
    {

        try
        {
            // Check for missing parameters
            if (app == null && city == null)
            {
                System.out.println("'app' and 'city' parameters are missing");
                return null;
            } else if (city == null)
            {
                System.out.println("'city' parameter is missing");
                return null;
            } else if (app == null)
            {
                System.out.println("'app' parameter is missing");
                return null;
            }

        // Create an SQL statement
        Statement stmt = app.con.createStatement();

        String strIssue31 =
                "SELECT city.Name, city.Population "
                        + "FROM city "
                        + "WHERE city.Name='" + city +"' ";

        // Execute SQL statement and Extrapolate the values from columns
        ResultSet rset = stmt.executeQuery(strIssue31);
        rset.next();

        //Creating Population ArrayList
        ArrayList<Population> pop = new ArrayList<Population>();
        //Formatting data and storing it
            Population p = new Population();
            p.name = rset.getString(1);
            p.population = rset.getInt(2);
            p.CityPop = rset.getInt(2);
            p.notINCityPop = 0;
            p.inCities = 100.00;
            p.notinCities = 0.00;


            pop.add(p);

        return pop;
    }
        catch (Exception e) //couldn't find city population
    {
        System.out.println(e.getMessage());
        System.out.println("Failed to get city population (Issue 31)");

        return null;
    }
}
}


