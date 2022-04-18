/**
 * Author: Andrei Vasiliu
 * Date: 29/04/2022
 * Issue 32: The number of people who speak the following languages from the greatest number to smallest, including the percentage of the world population: Chinese. English. Hindi. Spanish. Arabic.
 */
package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Issue32 {

    /**
     *  ----- getIssue32() -------
     *  Objectives:
     *      Return the number of people who speak: Chinese, English, Hindi, Spanish, Arabic,
     *      the percentage compared to the world population.
     *
     * @return  ArrayList<LPopulation>
     */
    public ArrayList<LPopulation> getIssue32(App app)
    {

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

            String strIssue32 =
                    "SELECT countrylanguage.Language, SUM(country.Population), (SELECT SUM(country.Population) FROM country) "
                            + "FROM country "
                            + "JOIN countrylanguage ON countrylanguage.CountryCode=country.Code "
                            + "WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                            + "GROUP BY 1 ORDER BY 2 DESC";

            // Execute SQL statement and Extrapolate the values from columns
            ResultSet rset = stmt.executeQuery(strIssue32);

            //Creating Population ArrayList
            ArrayList<LPopulation> p = new ArrayList<>();

            while(rset.next())
            {
                //Formatting data and storing it
                LPopulation po = new LPopulation();
                po.name = rset.getString(1);
                po.population = rset.getLong(2);
                po.pINworld = Math.round(((rset.getLong(2)/rset.getDouble(3))*100)*100)/100d;
                p.add(po);
            }

            return p;
        }
        catch (Exception e) //couldn't find population
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population (Issue 32)");

            return null;
        }
    }
}