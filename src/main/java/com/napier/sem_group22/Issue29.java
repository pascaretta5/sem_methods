/**
 * Author: Andrei Vasiliu
 * Date: 25/03/2022
 * Issue 29: The population of a country.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue29 {

    // storing temporary data
    long countryPop = 0;
    float citiesPop = 0;

    /**
     *  ----- getIssue29() -------
     *  Objectives:
     *      return the population of a country,
     *      population of people living in cities,
     *      population of people NOT living in cities,
     *      the percentage of the population living in cities,
     *      percentage NOT living in cities.
     *
     * @param country
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue29(App app, String country)
    {

        try
        {
            // Check for missing parameters
            if (app == null && country == null)
            {
                throw new NullPointerException("'app' and 'country' parameters missing");
            } else if (country == null)
            {
                throw new NullPointerException("'country' parameter missing");
            } else if (app == null)
            {
                throw new NullPointerException("'app' parameter missing");
            }


            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create strings for SQL statements
            String strIssue29 =
                    "SELECT SUM(country.Population) "
                            + "FROM country "
                            + "WHERE country.Name=" + "'" + country + "' ";

            String strIssue29b =
                    "SELECT SUM(city.Population) "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Name=" + "'" + country + "' ";

            // Execute SQL statements and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue29);
            rset.next();
            countryPop = rset.getLong(1);

            ResultSet rset2 = stmt.executeQuery(strIssue29b);
            rset2.next();
            citiesPop = rset2.getFloat(1);

            //Creating Population ArrayList
            ArrayList<Population> p = new ArrayList<Population>();
            //Formatting data and storing it
            Population po = new Population();
            po.name = country;
            po.population = countryPop;
            po.CityPop = rset2.getLong(1);
            po.notINCityPop = countryPop - rset2.getLong(1);
            po.inCities = Math.round((citiesPop/countryPop*100)*100)/100d;
            po.notinCities = 100d - Math.round((citiesPop/countryPop*100)*100)/100d;
            p.add(po);


            return p;
        }
        catch (Exception e) //couldn't find country population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population (Issue 29)");

            return null;
        }
    }

}