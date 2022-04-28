/**
 * Author: Andrei Vasiliu
 * Date: 25/03/2022
 * Issue 30: The population of a district.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue30 {

    // storing temporary data
    long districtPop = 0;

    /**
     *  ----- getIssue30() -------
     *  Objectives:
     *      return the population of a district,
     *      population of people living in cities,
     *      population of people NOT living in cities,
     *      the percentage of the population living in cities,
     *      percentage NOT living in cities.
     *
     * @param district
     * @return  ArrayList<Population>
     */
    public ArrayList<Population> getIssue30(App app, String district)
    {

        try
        {
            // Check for missing parameters
            if (app == null && district == null)
            {
                System.out.println("'app' and 'district' parameters missing");
                return null;
            } else if (district == null)
            {
                System.out.println("'district' parameter missing");
                return null;
            } else if (app == null)
            {
                System.out.println("'app' parameter missing");
                return null;
            }


            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            String strIssue30 =
                    "SELECT SUM(city.Population) "
                            + "FROM city "
                            + "WHERE city.District=" + "'" + district + "'";

            // Execute SQL statement and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue30);
            rset.next();
            districtPop = rset.getLong(1);

            //Creating Population ArrayList
            ArrayList<Population> p = new ArrayList<Population>();
            //Formatting data and storing it
            Population po = new Population();
            po.name = district;
            po.population = districtPop;
            po.CityPop = rset.getLong(1);
            po.notINCityPop = districtPop - rset.getLong(1);
            po.inCities = 100.00;
            po.notinCities = 0.00;
            p.add(po);


            return p;
        }
        catch (Exception e) //couldn't find district population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get district population (Issue 30)");

            return null;
        }
    }
}