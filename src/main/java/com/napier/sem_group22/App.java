/*
 * Author: Sara , Bruno
 * Date: 10/03/22
 * App with code to get data for issue #1, #2, #3, #4, #5. The main method call the method for the issue #5.
 *  The issue should provide the number of countries per continent they want to display.
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

    //--------------------Issue #5: All the top N countries in a continent where N is provided by the user------------------
    /* ----------- printCountries(ArrayList<Country> countries) ---------------
   Objective: print all the countries in the ArrayList.
   Parameters: ArrayList<Country> countries -- list of countries to be printed
   Return type: VOID
   */
    public ArrayList<Country> getTopCountryByContinentLargeToSmall(String continent, int limit) {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement

            //Needed to join both table CITY and COUNTRY in order to retrieve the right capital.
            String strPopulationLageSmall =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM city JOIN country ON CountryCode = Code "
                            + "WHERE country.capital = city.ID AND Continent LIKE '" + continent +"' "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + limit + "; ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries and to get the details
            while (rset.next())
            {
                Country count = new Country();
                count.code = rset.getString("country.Code");
                count.region = rset.getString("country.Region");
                count.capitalName = rset.getString("city.Name");
                count.continent = rset.getString("country.Continent");
                count.name = rset.getString("country.Name");
                count.population = rset.getInt("country.Population");
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
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-20s %-15s %-20s %-20s %-20s %-20s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all employees in the list
        for (Country c : countries)
        {
            String c_string =
                    String.format("%-20s %-15s %-20s %-20s %-20s %-20s", c.code, c.name, c.continent, c.region, c.population, c.capitalName);
            System.out.println(c_string);
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //------------------------------- Issue #5 --------------------------------
        // the user can declare any continent they want

        //------ NEED TO BE THOUGHT IN A WAY HOW TO ASK THE USER REMOTELY----------
        /*
        System.out.println("\nPlease, choose the continent: \n");
        Scanner myObj = new Scanner(System.in);
        String continent = myObj.nextLine();
        //The user can choose how many countries to display
        System.out.println("Top X number countries (Choose X): \n");
        Scanner myObj2 = new Scanner(System.in);
        int limit = myObj2.nextInt();
        */
        //For while, the following variables:
        String continent = "North America";
        int limit = 5;
        //get all countries from that region from largest to smallest area
        ArrayList<Country> countries = a.getTopCountryByContinentLargeToSmall(continent, limit);
        //print countries and column names
        a.printCountries(countries);



        // Disconnect from database
        a.disconnect();
    }
}