/**
 * Authors: Sara, Bruno, Andrei, Andrej
 * Date: 10/03/22
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
        // Loop over all countries in the list
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
     * ----------- printCity(ArrayList<Country> cities) ---------------
     *    Objective: print all the cities in the ArrayList.
     *    @param cities
     *    @return: void
     */
    public void printCities(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s", "City Name", "Country Name",  "District", "Population"));
        // Loop over all cities in the list
        for (City cit : cities)
        {
            if (cit == null)
                continue;
            String c_string =
                    String.format("%-30s %-30s %-30s %-30s", cit.name, cit.countryName, cit.district, cit.population);
            System.out.println(c_string);
        }
    }

    /**
     * ------------ printPopulation(ArrayList<Population> populations) ------------
     * Objective: Print the populations stored in the ArrayList.
     * @param populations
     * @return void
     */
    public static void printPopulation(ArrayList<Population> populations)
    {
        // Check populations is not null
        if (populations == null)
        {
            System.out.println("No populations");
            return;
        }
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s", "Name", "Population", "Living in cities", "NOT living in cities", "% living in cities", "% NOT living in cities"));
        // Loop over all populations in the list
        for (Population p : populations)
        {
            if (p == null)
                continue;
            String p_string =
                    String.format("%-30s %-30s %-30s %-30s %-30s %-30s", p.name, p.population, p.CityPop, p.notINCityPop, p.inCities, p.notinCities);
            System.out.println(p_string);
        }
    }

    /**
     * ------------ printLPopulation(ArrayList<LPopulation> language_population) ------------
     * Objective: Print the populations stored in the ArrayList.
     * @param langpop
     * @return void
     */
    public static void printLPopulation(ArrayList<LPopulation> langpop)
    {
        // Check populations is not null
        if (langpop == null)
        {
            System.out.println("No language populations");
            return;
        }
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s", "Name", "Population", "% in world"));
        // Loop over all populations in the list
        for (LPopulation lp : langpop)
        {
            if (lp == null)
                continue;
            String lp_string =
                    String.format("%-30s %-30s %-30s", lp.name, lp.population, lp.pINworld);
            System.out.println(lp_string);
        }
    }

    /**
     * Main method - allows connection to the database
     * @param args
     */
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

        Issue2 issue2 = new Issue2();
        ArrayList<Country> countries = issue2.getCountryByContinentLargeToSmall(a);
        a.printCountries(countries);

        // Disconnect from database
        a.disconnect();
    }
}