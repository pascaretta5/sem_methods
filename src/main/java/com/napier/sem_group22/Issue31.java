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
     * @return  ArrayList<City>
     */
    public ArrayList<City> getIssue31(App app, String city)
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
                "SELECT city.Name, country.Name, city.District, city.Population "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE city.Name LIKE '" + city +"' ";


        // Execute SQL statement and Extrapolate the values from columns
        ResultSet rset = stmt.executeQuery(strIssue31);
        rset.next();


        //Creating Population ArrayList
        ArrayList<City> cities = new ArrayList<City>();
        //Formatting data and storing it
            City city1= new City();

            city1.population = rset.getInt("city.Population");
            city1.name = rset.getString("city.Name");
            city1.district = rset.getString("city.District");
            city1.countryName = rset.getString("country.Name");
            cities.add(city1); // add city in ArrayList<City> cities


        return cities;
    }
        catch (Exception e) //couldn't find city population
    {
        System.out.println(e.getMessage());
        System.out.println("Failed to get city population (Issue 31)");

        return null;
    }
}
}


