/**
 * Author: Sara, Bruno, Andrei, Andrej
 * Date: 10/03/22
 *
 * Update 22/02/22 : Sara --  The method for the Issue #6 is called in the main method.
 */
package com.napier.sem_group22;

import java.sql.*;
import java.util.ArrayList;


public class App
{
    /**
     * Connection to MySQL database.
     */
    public Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +    Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
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
    /**
     * ---------------------------------------Issue #1-------------------------
     *    ----------- getCountryPopulationLargeToSmall() ---------------
     *    Objective: get all the countries population from largest to smallest.
     *    @return ArrayList<Country> countries -- list of countries to be printed
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

    /**
     * ---------------------------------------Issue #2-------------------------
     *     ----------- getCountryByContinentLargeToSmall() ---------------
     * Objective: get all the countries population in a continent from largest to smallest.
     * @return ArrayList<Country> countries -- list of countries to be printed
     * @param app
     */
    public ArrayList<Country> getCountryByContinentLargeToSmall(App app) {

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

    /**
     * ---------------------------------------Issue #3-------------------------
     *     ----------- getCountryByRegionLargeToSmall(String region) ---------------
     *     Objective: get all the countries in a determined region ordered from largest to smallest.
     * @param region
     * @return ArrayList<Country>
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

    /**
     * -------------------------------------- Issue #4 functions --------------------------------------
     * ----------- getThreeBiggestCountries(String N) ---------------
     *     Objective: get the N countries with the biggest population from each continent.
     *     @param N: Snumber of countries from each continent.
     *     Return type: ArrayList<Country>
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

    /**
     * --------------------Issue #5: All the top N countries in a continent where N is provided by the user--------
     *    Objective: get all N top populated countries in continents -- Large to Small.
     *    @param continent
     *    @param limit
     *    @return ArrayList<Country>
     */
    public ArrayList<Country> getTopCountryByContinentLargeToSmall(String continent, Integer limit) {

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

    /**
     * -------------------- printCountries()------------------
     *    Objective: print countries and the heather for the columns
     *    @param countries
     *    @return void
     */
    public void printCountries(ArrayList<Country> countries)
    {
        // Check countries is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-15s %-20s %-20s %-20s %-20s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all employees in the list
        for (Country c : countries)
        {
            if (c == null)
                continue;
            String c_string =
                    String.format("%-20s %-15s %-20s %-20s %-20s %-20s", c.code, c.name, c.continent, c.region, c.population, c.capitalName);
            System.out.println(c_string);
        }
    }

    /**
     * -------------------------------Issue 7: getAllCitiesLargestToSmallest --------------
     *    Objective: get all cities in the world ordered from largest to smallest.
     *    Parameters: String region -- specified region.
     *    Return type: ArrayList<Country>
     */
    public ArrayList<City> getAllCitiesLargestToSmallest() {

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

    /**
     * ----------- printCity(ArrayList<Country> cities) ---------------
     *    Objective: print all the cities in the ArrayList.
     *    Parameters: ArrayList<City> cities -- list of countries to be printed
     *    Return type: VOID
     */
    public void printCity(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-14s %-14s %-14s %-20s", "City Name", "Country Name",  "District", "Population"));
        // Loop over all countries in the list
        for (City cit : cities)
        {
            String c_string =
                    String.format("%-20s %-30s %-25s %-20s", cit.name, cit.countryName, cit.district, cit.population);
            System.out.println(c_string);
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        /**
         * ------------------------------- Issue #6 --------------------------------
         */
        /*
        String N = "3"; //input example
        String region = "Central America";
        /** Create instance of Issue6 Class-- this will have the required methods */
        /*
        Issue6 issue = new Issue6();
        ArrayList<Country> countries = issue.getNTopPopCountriesRegion(N, a, region);
        /** Print countries and column names */
        /*
        a.printCountries(countries);
        */
        /** Create instance of Issue6 Class-- this will have the required methods */
        Issue17 issue17 = new Issue17();
        ArrayList<City> cities = issue17.getIssue17(a);
        /** Print countries and column names */
        a.printCity(cities);

        // Disconnect from database
        a.disconnect();
    }
}