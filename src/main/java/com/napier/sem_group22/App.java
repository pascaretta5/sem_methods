/*
 * Author: Sara, Bruno
 * Date: 10/03/22
 * App with code to get data for issue #1, #2,#3, #4. Issue #4 method is called in main method,
 *  The top N (given N by the user in the terminal)
 * populated countries in the world where N is provided by the user.
 * get data from.
 */
package com.napier.sem_group22;

import java.io.InputStreamReader;
import java.util.Scanner;
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
    //---------------------------------------Issue #2-------------------------
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

    //---------------------------------------Issue #3-------------------------
    /* ----------- getCountryByRegionLargeToSmall(String region) ---------------
    Objective: get all the countries in a determined region ordered from largest to smallest.
    Parameters: String region -- specified region.
    Return type: ArrayList<Country>
    */
    public ArrayList<Country> getCountryByRegionLargeToSmall(String region) {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT Code, country.Population, Continent, country.Name, Region, city.Name "
                            +"FROM country JOIN city ON country.Capital = city.ID "
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

    //-------------------------------------- Issue #4 functions ---------------------------------------
    /* ----------- getThreeBiggestCountries(String N) ---------------
    Objective: get the N countries with the biggest population from each continent.
    Parameters: String N -- number of countries from each continent.
    Return type: ArrayList<Country>
    */
    public ArrayList<Country> getThreeBiggestCountries(String N) {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strThreeBiggestPopByCont =
                    "SELECT x.Code, x.Population, x.Continent, x.Name, x.Region, city.Name "
                            +"FROM country x  JOIN city ON x.Capital = city.ID " +
                            "WHERE x.name IN (SELECT * FROM (SELECT y.Name FROM country y WHERE y.Continent = x.Continent ORDER BY Population DESC LIMIT " + N + ") z) ORDER BY x.Continent;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strThreeBiggestPopByCont);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();


                count.code = rset.getString("Code");
                count.population = rset.getInt("Population");
                count.name = rset.getString("Name");
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

    /* ----------- printCountriesIssue4(ArrayList<Country> countries) ---------------
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
                    String.format("%-10s %-15s %-20s %-25s %-30s %-35s", c.code, c.population, c.continent, c.name, c.region, c.capitalName);
            System.out.println(c_string);
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to databasea
        a.connect();


        // ---------------------------- Issue #4 -------------
        //get N as input from the terminal
        /* cant get input from log in docker compose????
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Please enter the number of countries that you wish to get Updated : ");
        String N = scanner.nextLine();*/

        //sample input
        String N = "4";
        //create array with all the countries
        ArrayList<Country> countries = a.getThreeBiggestCountries(N);
        //print the countries report
        a.printCountries(countries);
        //print the countries





        // Disconnect from database
        a.disconnect();
    }
}