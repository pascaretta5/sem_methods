package com.napier.sem_group22;

import java.sql.*;
import java.util.ArrayList;


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
    /* ----------- getCountryPopulationLargeToSmall() -- Issue #1 ---------------
    Objective: get the name and the population from the workd database in order of lagest to smallest population.
    Parameters: None
    Return Type: ArrayList<Country> -- returns an aray with all the contries
    */
    public ArrayList<Country> getCountryPopulationLargeToSmall() {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT Population, Name "
                    +"FROM country "
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

    /* ----------- printCountriesPop(ArrayList<Country> countries) ---------------
    Objective: print columns names and all the data from the countries(name, population) in the ArrayList.
    Parameters: ArrayList<Country> countries -- takes an array with all the cuontries.
    Return type: VOID
    */
    /*public void printCountriesPop(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-25s", "Population", "Name"));
        // Loop over all employees in the list
        for (Country c : countries)
        {
            String c_string =
                    String.format("%-10s %-25s", c.population, c.name);
            System.out.println(c_string);
        }
    }*/
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        /* ---------- Issue #1 ----------
        //call method to execute the query and get the population
        ArrayList<Country> countries = a.getCountryPopulationLargeToSmall();
        //print Name and Population in console
        a.printCountriesPop(countries);*/


        // Disconnect from database
        a.disconnect();
    }
}