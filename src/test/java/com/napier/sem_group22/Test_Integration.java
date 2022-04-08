package com.napier.sem_group22;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class Test_Integration {
    static App app;

    static Issue1 issue1;
    static Issue2 issue2;
    static Issue3 issue3;
    static Issue4 issue4;
    static Issue5 issue5;
    static Issue6 issue6;
    static Issue7 issue7;
    static Issue17 issue17;
    static Issue18 issue18;
    static Issue19 issue19;
    static Issue20 issue20;
    static Issue21 issue21;
    static Issue24 issue24;
    static Issue25 issue25;
    static Issue26 issue26;
    static Issue28 issue28;
    static Issue29 issue29;
    static Issue30 issue30;


    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }


    /**
     * Issue 1
     */
    @Test
    void getIssue1Test()
    {
        ArrayList<Country> countries = issue1.getCountryPopulationLargeToSmall(app);

    }
    @Test
    void getIssue1TestNull()
    {
        ArrayList<Country> countries = issue1.getCountryPopulationLargeToSmall(null);

    }


    /**
     * Issue 2
     */
    @Test
    void getIssue2Test()
    {
        ArrayList<Country> countries = issue2.getCountryByContinentLargeToSmall(app);

    }
    @Test
    void getIssue2TestNull()
    {
        ArrayList<Country> countries = issue2.getCountryByContinentLargeToSmall(null);

    }


    /**
     * Issue 3
     */
    @Test
    void getIssue3TestRegionNull()
    {

        ArrayList<Country> countries = issue3.getCountryByRegionLargeToSmall(app, null);

    }
    @Test
    void getIssue3TestRegion()
    {

        ArrayList<Country> countries = issue3.getCountryByRegionLargeToSmall(app, "South America");

    }


    /**
     * Issue 4
     */
    String N;

    @Test
    void getIssue4Test()
    {
        ArrayList<Country> countries = issue4.getThreeBiggestCountries(app, N);

    }
    @Test
    void getIssue4TestNNull()
    {

        ArrayList<Country> countries = issue4.getThreeBiggestCountries(app, null);

    }


    /**
     * Issue 5
     */
    int limit = 0;
    String continent;

    @Test
    void getIssue5Test()
    {
        ArrayList<Country> countries = issue5.getTopCountryByContinentLargeToSmall(app, continent, limit);

    }
    @Test
    void getIssue5TestContinentNull()
    {

        ArrayList<Country> countries = issue5.getTopCountryByContinentLargeToSmall(app, null, limit);

    }
    @Test
    void getIssue5TestAllNull()
    {

        ArrayList<Country> countries = issue5.getTopCountryByContinentLargeToSmall(null, null, null);

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
     * Issue 7
     */
    @Test
    void getIssue7Test()
    {
        ArrayList<City> cities = issue7.getAllCitiesLargestToSmallest(app);

    }
    @Test
    void getIssue7TestNull()
    {
        ArrayList<City> cities = issue7.getAllCitiesLargestToSmallest(null);

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


    /**
     * Issue 19
     */
    /*@Test
    void getIssue19()
    {
        ArrayList<City> city1 = issue19.getIssue19(app);
        ArrayList<City> city2 = new ArrayList<>();

        City acity = new City();
        acity.name = "Canberra";
        acity.countryName = "Australia";
        acity.district = "Capital Region";
        acity.population = 322723;
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
    void getIssue19Null()
    {
        ArrayList<City> city1 = issue19.getIssue19(null);

    }


    /**
     * Issue 20
     */
    @Test
    void getTopNIssue20Test()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20("1", app);
        ArrayList<City> city2 = new ArrayList<>();
        City acity = new City();
        acity.name = "Seoul";
        acity.countryName = "South Korea";
        acity.district = "Seoul";
        acity.population = 9981619;
        city2.add(acity); // add country in ArrayList<Country> countries

        for(int i = 0; i < city1.size(); i++ ) {
            assertEquals(city2.get(i).name, city1.get(i).name, "Test getIssue20 1/4 Failed");
            assertEquals(city2.get(i).countryName, city1.get(i).countryName, "Test getIssue20 2/4 Failed");
            assertEquals(city2.get(i).district, city1.get(i).district, "Test getIssue20 3/4 Failed");
            assertEquals(city2.get(i).population, city1.get(i).population, "Test getIssue20 4/4 Failed");
        }
    }

    @Test
    void getTopNIssue20TestNullN()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20(null, app);

    }

    @Test
    void getTopNIssue20TestNullArray()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20("1", null);

    }

    @Test
    void getTopNIssue20TestNullAllParams()
    {
        ArrayList<City> city1 = issue20.getTopNIssue20(null, null);

    }


    /**
     * Issue 21
     */
    /*@Test
    void getTopNIssue21Test()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21("1", app, "Asia");
        ArrayList<City> city2 = new ArrayList<>();
        City acity = new City();
        acity.name = "Seoul";
        acity.countryName = "South Korea";
        acity.district = "Seoul";
        acity.population = 9981619;
        city2.add(acity); // add city in ArrayList<City> cities

        for(int i = 0; i < city1.size(); i++ ) {
            assertEquals(city2.get(i).name, city1.get(i).name, "Test getIssue20 1/4 Failed");
            assertEquals(city2.get(i).countryName, city1.get(i).countryName, "Test getIssue20 2/4 Failed");
            assertEquals(city2.get(i).district, city1.get(i).district, "Test getIssue20 3/4 Failed");
            assertEquals(city2.get(i).population, city1.get(i).population, "Test getIssue20 4/4 Failed");
        }
    }*/

    @Test
    void getTopNIssue21TestNullN()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21(null, app, "Asia");

    }

    @Test
    void getTopNIssue21TestNullArray()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21("2", null, "Asia");

    }

    @Test
    void getTopNIssue21TestNullContinent()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21("2", app, null);

    }

    @Test
    void getTopNIssue21TestNullAllParams()
    {
        ArrayList<City> city1 = issue21.getTopNIssue21(null, null, null);

    }


    /**
     * Issue 24
     */
    @Test
    void getIssue24AppNull()
    {
        ArrayList<Population> pop1 = issue24.getIssue24(null);
    }
    @Test
    void getIssue24CountryNull()
    {
        ArrayList<Population> pop1 = issue24.getIssue24(app);
    }


    /**
     * Issue 25
     */
    @Test
    void getIssue25AppNull()
    {
        ArrayList<Population> pop1 = issue25.getIssue25(null);
    }
    @Test
    void getIssue25CountryNull()
    {
        ArrayList<Population> pop1 = issue25.getIssue25(app);
    }


    /**
     * Issue 26
     */
    @Test
    void getIssue26AppNull()
    {
        ArrayList<Population> pop1 = issue26.getIssue26(null);
    }
    @Test
    void getIssue26CountryNull()
    {
        ArrayList<Population> pop1 = issue26.getIssue26(app);
    }


   /**
     * Issue 28
     */
    @Test
    void getIssue28AppNull()
    {
        ArrayList<Population> pop1 = issue28.getIssue28(app, null);
    }
    @Test
    void getIssue28CountryNull()
    {
        ArrayList<Population> pop1 = issue28.getIssue28(null, "Middle East");
    }


    /**
     * Issue 29
     */
    /*@Test
    void getIssue29Test()
    {
        ArrayList<Population> pop1 = issue29.getIssue29(app, "Netherlands");
        ArrayList<Population> pop2 = new ArrayList<Population>();
        Population po = new Population();
        po.name = "Netherlands";
        po.population = 15864000;
        po.inCities = 32.652855;
        po.notinCities = 67.347145;
        pop2.add(po);

        for(int i = 0; i < pop1.size(); i++ ) {
            assertEquals(pop2.get(i).name, pop1.get(i).name, "Test getIssue29Test 1/4 Failed");
            assertEquals(pop2.get(i).population, pop1.get(i).population, "Test getIssue29Test 2/4 Failed");
            assertEquals(pop2.get(i).inCities, pop1.get(i).inCities, "Test getIssue29Test 3/4 Failed");
            assertEquals(pop2.get(i).notinCities, pop1.get(i).notinCities, "Test getIssue29Test 4/4 Failed");
        }
    }*/
    @Test
    void getIssue29AppNull()
    {
        ArrayList<Population> pop1 = issue29.getIssue29(null, "Netherlands");
    }
    @Test
    void getIssue29CountryNull()
    {
        ArrayList<Population> pop1 = issue29.getIssue29(app, null);
    }
    @Test
    void getIssue29AllNull()
    {
        ArrayList<Population> pop1 = issue29.getIssue29(null, null);
    }


    /**
     * Issue30
     */
    @Test
    void getIssue30AppNull()
    {
        ArrayList<Population> pop1 = issue30.getIssue30(null, "Seoul");
    }
    @Test
    void getIssue30DistrictNull()
    {
        ArrayList<Population> pop1 = issue30.getIssue30(app, null);
    }
    @Test
    void getIssue30AllNull()
    {
        ArrayList<Population> pop1 = issue30.getIssue30(null, null);
    }
}