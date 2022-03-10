/*
 * Author: Sara Hussein Celda
 * Matric Num: 40496531
 * Date: 08/03/22
 * App with code to get data for issue #3. The issue should replace the region variable with the region that they desire to
 * get data from.
 */
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

    /* ----------- getCountryByRegionLargeToSmall(String region) ---------------
    Objective: get all the countries in a determined region ordered from largest to smallest.
    Parameters: String region -- specified region.
    Return type: ArrayList<Country>
    */
    /*
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

    /* ----------- getAllCitiesLargestToSmallest --------------- ISSUE 7
   Objective: get all cities in the world ordered from largest to smallest.
   Parameters: String region -- specified region.
   Return type: ArrayList<Country>
   */
    public ArrayList<Country> getAllCitiesLargestToSmallest() {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strPopulationLageSmall =
                    "SELECT city.name, country.name, district, city.population "
                            +"FROM city JOIN country ON CountryCode = Code "
                            + "ORDER BY city.population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strPopulationLageSmall);

            //Create Country ArrayList
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned and go through all countries to get the details
            while (rset.next())
            {
                Country count = new Country();
                count.city_name = rset.getString("city.name");
                count.name = rset.getString("country.name");
                count.district = rset.getString("district");
                count.population = rset.getInt("city.population");
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
        System.out.println(String.format("%-14s %-14s %-14s %-20s", "City Name", "Country Name",  "District", "Population"));
        // Loop over all countries in the list
        for (Country c : countries)
        {
            String c_string =
                    String.format("%-20s %-30s %-25s %-20s", c.city_name, c.name, c.district, c.population);
            System.out.println(c_string);
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to databasea
        a.connect();

        /*
        //------------------------------- Issue #3 --------------------------------
        // the user can declare any region that they want
        String region = "Caribbean";
        //get all countries from that region from largest to smallest area
        ArrayList<Country> countries = a.getCountryByRegionLargeToSmall(region);
        //print countries and column names
        a.printCountries(countries);
*/

        //------------------------------- Issue #7 --------------------------------
        //get all countries from that region from largest to smallest area
        ArrayList<Country> countries = a.getAllCitiesLargestToSmallest();
        //print countries and column names
        a.printCountries(countries);

        // Disconnect from database
        a.disconnect();
    }
}