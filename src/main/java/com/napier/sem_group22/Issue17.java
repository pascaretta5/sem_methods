package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*  To place into main /** Create instance of Issue6 Class-- this will have the required methods */
        //Issue17 issue17 = new Issue17();
                //ArrayList<City> cities = issue17.getIssue17(a);
       // /** Print countries and column names */
       // a.printCity(cities);

public class Issue17 {

        /**
         * -------------------------------Issue 17: getIssue17 --------------
         *    Objective: All the capital cities in the world organised by largest population to smallest.
         *    Return type: ArrayList<Country>
         */
        public ArrayList<City> getIssue17(App app) {

            try
            {
                // Create an SQL statement
                Statement stmt = app.con.createStatement();

                // Create string for SQL statement
                String strIssue17 =
                        "SELECT city.name, country.name, district, city.population "
                                +"FROM city JOIN country ON country.Capital = city.ID "
                                + "ORDER BY city.population DESC;";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strIssue17);

                //Create Country ArrayList
                ArrayList<City> cities = new ArrayList<City>();

                // Check one is returned and go through all countries to get the details
                while (rset.next())
                {
                    City acity = new City();
                    acity.name = rset.getString("city.name");
                    acity.countryName = rset.getString("country.name");
                    acity.district = rset.getString("district");
                    acity.population = rset.getInt("city.population");
                    cities.add(acity); // add country in ArrayList<Country> countries

                }
                return cities; // return ArrayList
            }
            catch (Exception e) //no country found
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get countries population");
                return null;
            }
        }

}
