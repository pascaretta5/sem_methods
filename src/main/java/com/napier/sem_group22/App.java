/*
Authors: Sara, Bruno.
Date last update: 10/03/22
Issues #1 and #2 code.
 */
package com.napier.sem_group22;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database   ---- localhost:33060 -- db:3306
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    //---------------------------------------Issue #1-------------------------
    /* ----------- getCountryPopulationLargeToSmall() ---------------
   Objective: get all the countries population from largest to smallest.
   Parameters: NONE
   Return type: ArrayList<Country> countries -- list of countries to be printed
   */
    public ArrayList<Country> getCountryPopulationLargeToSmall() {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT Code, country.Population, Continent, country.Name, Region, city.Name "
                            +"FROM country JOIN city ON country.Capital = city.ID "
                            + "ORDER BY Population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned
            while (rset.next())
            {
                Country count = new Country();
                count.name = rset.getString("Name");
                count.population = rset.getInt("Population");
                count.code = rset.getString("Code");
                count.continent = rset.getString("Continent");
                count.region = rset.getString("Region");
                count.capitalName = rset.getString("city.Name");

                countries.add(count);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population");
            return null;
        }
    }
    //---------------------------------------Issue #3-------------------------
    /* ----------- getCountryByContinentLargeToSmall() ---------------
   Objective: get all the countries population in a continent from largest to smallest.
   Parameters: NONE
   Return type: ArrayList<Country> countries -- list of countries to be printed
   */
    public ArrayList<Country> getCountryByContinentLargeToSmall() {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT Code, country.Population, Continent, country.Name, Region, city.Name "
                            +"FROM country JOIN city ON country.Capital = city.ID "
                            + "ORDER BY Continent, Population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();
                count.name = rset.getString("Name");
                count.population = rset.getInt("Population");
                count.code = rset.getString("Code");
                count.continent = rset.getString("Continent");
                count.region = rset.getString("Region");
                count.capitalName = rset.getString("city.Name");
                countries.add(count); // add country in ArrayList<Country> countries
            }
            return countries; // return ArrayList
        }
        catch (Exception e) //no country found
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population");
            return null;
        }
    }

    /* ----------- printCountries(ArrayList<Country> countries) ---------------
   Objective: print all the countries in the ArrayList.
   Parameters: ArrayList<Country> countries -- list of countries to be printed
   Return type: VOID
   */
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-25s %-30s %-35s", "Code", "Population", "Continent", "Name", "Region", "Capital"));
        // Loop over all employees in the list
        for (Country c : countries)
        {
            String c_string =
                    String.format("%-10s %-15s %-20s %-25s %-30s %-35s", c.code, c.population, c.continent,  c.name, c.region, c.capitalName);
            System.out.println(c_string);
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to databasea
        a.connect();

        //------------------------------- Issue #2 --------------------------------
        //get all countries by continent from largest to smallest area
        ArrayList<Country> countries = a.getCountryByContinentLargeToSmall();
        //print countries and column names
        a.printCountries(countries);



        // Disconnect from database
        a.disconnect();
    }
}