package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class Test_Integration {
    static App app;

    static Issue6 issue6;
    static Issue17 issue17;
    static Issue18 issue18;


    @BeforeAll
    static void init()
    {
        app = new App();
        issue6 = new Issue6();
        app.connect("localhost:33060", 30000);
        issue17 = new Issue17();
        issue18 = new Issue18();
    }

    /**
     * Issue 1
     */


    @Test
    void getIssue1Test()
    {
        ArrayList<Country> countries = app.getCountryPopulationLargeToSmall();

    }
    @Test
    void getIssue1TestNull()
    {
        ArrayList<Country> countries = app.getCountryByContinentLargeToSmall(null);

    }

    /**
     * Issue 2
     */


    @Test
    void getIssue2Test()
    {
        ArrayList<Country> countries = app.getCountryByContinentLargeToSmall(app);

    }
    @Test
    void getIssue2TestNull()
    {
        ArrayList<Country> countries = app.getCountryByContinentLargeToSmall(null);

    }

    /**
     * Issue 3
     */


    @Test
    void getIssue3TestRegionNull()
    {

        ArrayList<Country> countries = app.getCountryByRegionLargeToSmall(null);

    }
    @Test
    void getIssue3TestRegion()
    {

        ArrayList<Country> countries = app.getCountryByRegionLargeToSmall("South America");

    }

    /**
     * Issue 4
     */



    String N;

    @Test
    void getIssue4Test()
    {
        ArrayList<Country> countries = app.getThreeBiggestCountries(N);

    }
    @Test
    void getIssue4TestNNull()
    {

        ArrayList<Country> countries = app.getThreeBiggestCountries(null);

    }

    /**
     * Issue 5
     */

    int limit = 0;
    String continent;

    @Test
    void getIssue5Test()
    {
        ArrayList<Country> countries = app.getTopCountryByContinentLargeToSmall(continent, limit);

    }
    @Test
    void getIssue5TestContinentNull()
    {

        ArrayList<Country> countries = app.getTopCountryByContinentLargeToSmall(null, limit);

    }
    @Test
    void getIssue5TestAllNull()
    {

        ArrayList<Country> countries = app.getTopCountryByContinentLargeToSmall(null, null);

    }

    /**
     * Issue 6
     */



    @Test
    void getNTopPopCountriesRegionTest()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("1", app, "Central America");
        ArrayList<Country> countries2 = new ArrayList<>();
        Country c1 = new Country();
        c1.code = "MEX";
        c1.name = "Mexico";
        c1.continent = "North America";
        c1.region = "Central America";
        c1.population = 98881000;
        c1.capitalName = "Ciudad de México";

        countries2.add(c1);

        for(int i = 0; i < countries1.size(); i++ ) {

            assertEquals(countries2.get(i).code, countries1.get(i).code, "Test getNTopPopCountriesRegionTest 1/6 Failed");
            assertEquals(countries2.get(i).name, countries1.get(i).name, "Test getNTopPopCountriesRegionTest 2/6 Failed");
            assertEquals(countries2.get(i).continent, countries1.get(i).continent, "Test getNTopPopCountriesRegionTest 3/6 Failed");
            assertEquals(countries2.get(i).region, countries1.get(i).region, "Test getNTopPopCountriesRegionTest 4/6 Failed");
            assertEquals(countries2.get(i).population, countries1.get(i).population, "Test getNTopPopCountriesRegionTest 5/6 Failed");
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName, "Test getNTopPopCountriesRegionTest 6/6 Failed");
        }
    }

    @Test
    void getNTopPopCountriesRegionTestNullN()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion(null, app, "Central America");

    }

    @Test
    void getNTopPopCountriesRegionTestNullRegion()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("2", app, null);

    }

    @Test
    void getNTopPopCountriesRegionTestNullApp()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("2", null, "Central America");

    }

    @Test
    void getNTopPopCountriesRegionTestNullAllParams()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion(null, null, null);

    }

    /**
     * Issue 17
     */

    /*
    @Test
    void getIssue17()
    {
        ArrayList<City> city1 = issue17.getIssue17(app);
        ArrayList<City> city2 = new ArrayList<>();

        City acity = new City();
        acity.name = "Seoul";
        acity.countryName = "South Korea";
        acity.district = "Seoul";
        acity.population = 9981619;
        city2.add(acity); // add country in ArrayList<Country> countries

        for(int i = 0; i < city1.size(); i++ ) {
            assertEquals(city2.get(i).name, city1.get(i).name);
            assertEquals(city2.get(i).countryName, city1.get(i).countryName);
            assertEquals(city2.get(i).district, city1.get(i).district);
            assertEquals(city2.get(i).population, city1.get(i).population);
        }
    }
*/

    @Test
    void getIssue17Null()
    {
        ArrayList<City> city1 = issue17.getIssue17(null);

    }

    /**
     * Issue 18
     */
    @Test
    void getIssue18Test()
    {
        ArrayList<City> cities = issue18.getIssue18(app);

    }
    @Test
    void getIssue18TestNull()
    {
        ArrayList<City> cities = issue18.getIssue18(null);

    }


}
