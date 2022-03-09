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

    /* ----------- getCountryByRegionLargeToSmall(String region) ---------------
    Objective: get all the countries in a determined region ordered from largest to smallest.
    Parameters: String region -- specified region.
    Return type: ArrayList<Country>
    */
    /* ------------ getCountryByRegionLargeToSmall(string region) METHOD----------
    public ArrayList<Country> getCountryByRegionLargeToSmall(String region) {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT SurfaceArea, Name "
                            +"FROM country "
                            +"WHERE Region LIKE '" + region + "' "
                            + "ORDER BY SurfaceArea DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();

                count.name = rset.getString("Name");
                count.surface_area = rset.getInt("SurfaceArea");
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
    */
    /* ----------- printCountries(ArrayList<Country> countries) ---------------
   Objective: print all the countries in the ArrayList.
   Parameters: ArrayList<Country> countries -- list of countries to be printed
   Return type: VOID
   */
    /*
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s", "SurfaceArea", "Name"));
        // Loop over all employees in the list
        for (Country c : countries)
        {
            String c_string =
                    String.format("%-10s %-15s", c.surface_area, c.name);
            System.out.println(c_string);
        }
    }
    */
    public ArrayList<Country> getCountryByContinentLargeToSmall() {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT Continent, Name, Population "
                            +"FROM country "
                            + "ORDER BY Continent, Population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();
                count.continent = rset.getString("Continent");
                count.name = rset.getString("Name");
                count.population = rset.getInt("Population");
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
        System.out.println(String.format("%-20s %-20s %-20s", "Continent", "Name", "Population"));
        // Loop over all employees in the list
        for (Country c : countries)
        {
            String c_string =
                    String.format("%-20s %-20s %-20s", c.continent, c.name, c.population);
            System.out.println(c_string);
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to databasea
        a.connect();

        //------------------------------- Issue #3 --------------------------------
        // the user can declare any region that they want

        //get all countries from that region from largest to smallest area
        ArrayList<Country> countries = a.getCountryByContinentLargeToSmall();
        //print countries and column names
        a.printCountries(countries);



        // Disconnect from database
        a.disconnect();
    }
}