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
        city = "Recife";
        String strIssue31 =
                "SELECT Population "
                        + "FROM city "
                        + "WHERE Name =" + "'" + city + "'";

        // Execute SQL statement and Extrapolate the values from columns
        ResultSet rset = stmt.executeQuery(strIssue31);
        rset.next();


        //Creating Population ArrayList
        ArrayList<Population> p = new ArrayList<Population>();
        //Formatting data and storing it
        Population po = new Population();
        po.name = city;
        po.CityPop = rset.getLong(1);
        p.add(po);


        return p;
    }
        catch (Exception e) //couldn't find city population
    {
        System.out.println(e.getMessage());
        System.out.println("Failed to get city population (Issue 31)");

        return null;
    }
}
}


