package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.event.PopupMenuListener;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    static App app;

    static Issue1 issue1;
    static Issue2 issue2;
    static Issue3 issue3;
    static Issue4 issue4;
    static Issue5 issue5;
    static Issue6 issue6;
    static Issue7 issue7;
    static Issue8 issue8;
    static Issue9 issue9;
    static Issue10 issue10;
    static Issue11 issue11;
    static Issue12 issue12;
    static Issue13 issue13;
    static Issue14 issue14;
    static Issue15 issue15;
    static Issue16 issue16;
    static Issue17 issue17;
    static Issue18 issue18;
    static Issue19 issue19;
    static Issue20 issue20;
    static Issue21 issue21;
    static Issue22 issue22;
    static Issue23 issue23;
    static Issue24 issue24;
    static Issue25 issue25;
    static Issue26 issue26;
    static Issue27 issue27;
    static Issue28 issue28;
    static Issue29 issue29;
    static Issue30 issue30;
    static Issue31 issue31;
    static Issue32 issue32;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 3000);

        issue1 = new Issue1();
        issue2 = new Issue2();
        issue3 = new Issue3();
        issue4 = new Issue4();
        issue5 = new Issue5();
        issue6 = new Issue6();
        issue7 = new Issue7();
        issue8 = new Issue8();
        issue9 = new Issue9();
        issue10 = new Issue10();
        issue11 = new Issue11();
        issue12 = new Issue12();
        issue13 = new Issue13();
        issue14 = new Issue14();
        issue15 = new Issue15();
        issue16 = new Issue16();
        issue17 = new Issue17();
        issue18 = new Issue18();
        issue19 = new Issue19();
        issue20 = new Issue20();
        issue21 = new Issue21();
        issue22 = new Issue22();
        issue23 = new Issue23();
        issue24 = new Issue24();
        issue25 = new Issue25();
        issue26 = new Issue26();
        issue27 = new Issue27();
        issue28 = new Issue28();
        issue29 = new Issue29();
        issue30 = new Issue30();
        issue31 = new Issue31();
        issue32 = new Issue32();
    }
    /**
     * ---------------- Tests for Issue 1 -----------------------
     * getCountryPopulationLargeToSmallTest() -- test if the sql statement works
     * getCountryPopulationLargeToSmallTestNull() -- test error handling if app is null
     */
    @Test
    void getCountryPopulationLargeToSmallTest(){
        ArrayList<Country> countries1 = issue1.getCountryPopulationLargeToSmall(app);
        ArrayList<Country> countries2 = new ArrayList<>();
        Objects.equals(countries2, countries1);

    }

    /**
     * ------------------ Tests for Issue 2
     * getCountryByContinentLargeToSmallTestNull() -- test error handling if app is null
     * getCountryByContinentLargeToSmallNormal() -- test if the sql statement works
     */
    @Test
    void getCountryByContinentLargeToSmallNormal(){
        ArrayList<Country> countries1 = issue2.getCountryByContinentLargeToSmall(app);
        ArrayList<Country> countries2 = new ArrayList<>();

        Objects.equals(countries2, countries1);
    }

    /**
     * Test for Issue 3
     */
    @Test
    void getCountryByRegionLargeToSmallTest()
    {
        ArrayList<Country> countries1 = issue3.getCountryByRegionLargeToSmall(app, "Eastern Asia");
        ArrayList<Country> countries2 = new ArrayList<>();
        Country c1 = new Country();
        c1.code = "CHN";
        c1.name = "China";
        c1.continent = "Asia";
        c1.region = "Eastern Asia";
        c1.population = 1277558000;
        c1.capitalName = "Peking";

        Country c2 = new Country();
        c2.code = "MNG";
        c2.name = "Mongolia";
        c2.continent = "Asia";
        c2.region = "Eastern Asia";
        c2.population = 2662000;
        c2.capitalName = "Ulan Bator";

        countries2.add(c1);
        countries2.add(c2);

        for(int i = 0; i < countries2.size(); i++ ) {
            assertEquals(countries2.get(i).code, countries1.get(i).code);
            assertEquals(countries2.get(i).name, countries1.get(i).name);
            assertEquals(countries2.get(i).continent, countries1.get(i).continent);
            assertEquals(countries2.get(i).region, countries1.get(i).region);
            assertEquals(countries2.get(i).population, countries1.get(i).population);
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName);
        }
    }

    /**
     * Test for Issue 4
     */
    @Test
    void getNBiggestCountriesTest()
    {
        ArrayList<Country> countries1 = issue4.getNBiggestCountries(app, "1");
        ArrayList<Country> countries2 = new ArrayList<>();
        Country c1 = new Country();
        c1.code = "CHN";
        c1.name = "China";
        c1.continent = "Asia";
        c1.region = "Eastern Asia";
        c1.population = 1277558000;
        c1.capitalName = "Peking";

        Country c2 = new Country();
        c2.code = "RUS";
        c2.name = "Russian Federation";
        c2.continent = "Europe";
        c2.region = "Eastern Europe";
        c2.population = 146934000;
        c2.capitalName = "Moscow";

        countries2.add(c1);
        countries2.add(c2);

        for(int i = 0; i < countries2.size(); i++ ) {
            assertEquals(countries2.get(i).code, countries1.get(i).code);
            assertEquals(countries2.get(i).name, countries1.get(i).name);
            assertEquals(countries2.get(i).continent, countries1.get(i).continent);
            assertEquals(countries2.get(i).region, countries1.get(i).region);
            assertEquals(countries2.get(i).population, countries1.get(i).population);
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName);
        }
    }
    /**
     * -------------------- Tests for Issue5 ------------------------
     * -getTopCountryByContinentLargeToSmallTestAllNormal -- test that the sql statement works
     * -getTopCountryByContinentLargeToSmallTestAppNull -- test error handling if app instance class null
     * -getTopCountryByContinentLargeToSmallTestContinentNull -- test error handling if continent null
     * -getTopCountryByContinentLargeToSmallTestLimitNull -- test error handling if limit is null
     * -getTopCountryByContinentLargeToSmallTestAllNull -- test error handling if all @param null
     */
    @Test
    void getTopCountryByContinentLargeToSmallTest()
    {
        ArrayList<Country> countries1 = issue5.getTopCountryByContinentLargeToSmall(app, "Asia", 1);
        ArrayList<Country> countries2 = new ArrayList<>();
        Country c1 = new Country();
        c1.code = "CHN";
        c1.name = "China";
        c1.continent = "Asia";
        c1.region = "Eastern Asia";
        c1.population = 1277558000;
        c1.capitalName = "Peking";


        countries2.add(c1);

        for(int i = 0; i < countries1.size(); i++ ) {
            assertEquals(countries2.get(i).code, countries1.get(i).code);
            assertEquals(countries2.get(i).name, countries1.get(i).name);
            assertEquals(countries2.get(i).continent, countries1.get(i).continent);
            assertEquals(countries2.get(i).region, countries1.get(i).region);
            assertEquals(countries2.get(i).population, countries1.get(i).population);
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName);
        }
    }




    /**
     * -------------------- Tests for Issue6 ------------------------
     * -getNTopPopCountriesRegionTest() -- test that the sql statement works
     * -getNTopPopCountriesRegionTestNullN() -- test error handling if N null
     * -getNTopPopCountriesRegionTestNullRegion() -- test error handling if Region null
     * -getNTopPopCountriesRegionTestNullApp() -- test error handling if App instance class null
     * -getNTopPopCountriesRegionTestNullAllParams() -- test error handling if all @param null
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
            assertEquals(countries2.get(i).code, countries1.get(i).code);
            assertEquals(countries2.get(i).name, countries1.get(i).name);
            assertEquals(countries2.get(i).continent, countries1.get(i).continent);
            assertEquals(countries2.get(i).region, countries1.get(i).region);
            assertEquals(countries2.get(i).population, countries1.get(i).population);
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName);
        }
    }

    /**
     * ------------------ Tests for Issue 7
     * getAllCitiesLargestToSmallestNull() -- test error handling if app is null
     * getAllCitiesLargestToSmallestNormal() -- test if the sql statement works
     */
    @Test
    void getAllCitiesLargestToSmallest(){
        ArrayList<City> cities1 = issue7.getAllCitiesLargestToSmallest(app);
        ArrayList<City> cities2 = new ArrayList<>();

        Objects.equals(cities2, cities1);
    }

    /**
     * -------------------- Tests for Issue8 ------------------------
     * -getCitiesLargeSmallPopTest -- test that the sql statement works
     * -getCitiesLargeSmallPopNullContinent() -- test error handling if Continent null
     * -getCitiesLargeSmallPopNullApp() -- test error handling if App instance class null
     * -getCitiesLargeSmallPopNullAllParams() -- test error handling if all @param null
     */
    @Test
    void getCitiesLargeSmallPopTest()
    {
        ArrayList<City> cities = issue8.getCitiesLargeSmallPop(app, "Europe");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Moscow";
        c1.countryName = "Russian Federation";
        c1.district = "Moscow (City)";
        c1.population = 8389200;

        City c2 = new City();
        c2.name = "London";
        c2.countryName = "United Kingdom";
        c2.district = "England";
        c2.population = 7285000;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue8 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue8 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue8 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue8 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue9 ------------------------
     * -getCitiesLargeSmallPopRegionTest -- test that the sql statement works
     * -getCitiesLargeSmallPopRegionNullRegion() -- test error handling if Region null
     * -getCitiesLargeSmallPopRegionNullApp() -- test error handling if App instance class null
     * -getCitiesLargeSmallPopRegionNullAllParams() -- test error handling if all @param null
     */
    @Test
    void getCitiesLargeSmallPopRegionTest()
    {
        ArrayList<City> cities = issue9.getCitiesLargeSmallPopRegion(app, "Caribbean");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "La Habana";
        c1.countryName = "Cuba";
        c1.district = "La Habana";
        c1.population = 2256000;

        City c2 = new City();
        c2.name = "Santo Domingo de Guzmán";
        c2.countryName = "Dominican Republic";
        c2.district = "Distrito Nacional";
        c2.population = 1609966;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue9 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue9 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue9 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue9 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue10 ------------------------
     * -getCitiesLargeSmallPopCountryTest -- test that the sql statement works
     * -getCitiesLargeSmallPopCountryNullCountry() -- test error handling if Country null
     * -getCitiesLargeSmallPopCountryNullApp() -- test error handling if App instance class null
     * -getCitiesLargeSmallPopRegionNullAllParams() -- test error handling if all @param null
     */
    @Test
    void getCitiesLargeSmallPopCountryTest()
    {
        ArrayList<City> cities = issue10.getCitiesLargeSmallPopCountry(app, "Japan");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Tokyo";
        c1.countryName = "Japan";
        c1.district = "Tokyo-to";
        c1.population = 7980230;

        City c2 = new City();
        c2.name = "Jokohama [Yokohama]";
        c2.countryName = "Japan";
        c2.district = "Kanagawa";
        c2.population = 3339594;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue10 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue10 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue10 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue10 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue11 ------------------------
     * -getCitiesLargeSmallPopDistrictTest -- test that the sql statement works
     * -getCitiesLargeSmallPopDistrictNullDistrict() -- test error handling if District null
     * -getCitiesLargeSmallPopDistrictNullApp() -- test error handling if App instance class null
     * -getCitiesLargeSmallPopDistrictNullAllParams() -- test error handling if all @param null
     */
    @Test
    void getCitiesLargeSmallPopDistrictTest()
    {
        ArrayList<City> cities = issue11.getCitiesLargeSmallPopDistrict(app, "Gelderland");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Apeldoorn";
        c1.countryName = "Netherlands";
        c1.district = "Gelderland";
        c1.population = 153491;

        City c2 = new City();
        c2.name = "Nijmegen";
        c2.countryName = "Netherlands";
        c2.district = "Gelderland";
        c2.population = 152463;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue10 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue10 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue10 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue10 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue12 ------------------------
     * -getIssue12Test -- test that the sql statement works
     * -getIssue12TestNullN() -- test error handling if N is null
     * -getIssue12TestNullApp() -- test error handling if App instance class null
     * -getIssue12NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue12Test()
    {
        ArrayList<City> cities = issue12.getTopNIssue12("2", app);
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Seoul";
        c1.countryName = "South Korea";
        c1.district = "Seoul";
        c1.population = 9981619;

        City c2 = new City();
        c2.name = "Jakarta";
        c2.countryName = "Indonesia";
        c2.district = "Jakarta Raya";
        c2.population = 9604900;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue12 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue12 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue12 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue12 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue13 ------------------------
     * -getIssue13Test -- test that the sql statement works
     * -getIssue13TestNullN() -- test error handling if N is null
     * -getIssue13TestNullApp() -- test error handling if App instance class null
     * -getIssue13TestNullContinent() -- test error handling if continent is null
     * -getIssue13NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue13Test()
    {
        ArrayList<City> cities = issue13.getTopNIssue13("2", app, "Europe");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Moscow";
        c1.countryName = "Russian Federation";
        c1.district = "Moscow (City)";
        c1.population = 8389200;

        City c2 = new City();
        c2.name = "London";
        c2.countryName = "United Kingdom";
        c2.district = "England";
        c2.population = 7285000;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue13 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue13 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue13 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue13 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue14 ------------------------
     * -getIssue14Test -- test that the sql statement works
     * -getIssue14TestNullN() -- test error handling if N is null
     * -getIssue14TestNullApp() -- test error handling if App instance class null
     * -getIssue14TestNullRegion() -- test error handling if region is null
     * -getIssue14NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue14Test()
    {
        ArrayList<City> cities = issue14.getTopNIssue14("2", app, "Eastern Europe");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Moscow";
        c1.countryName = "Russian Federation";
        c1.district = "Moscow (City)";
        c1.population = 8389200;

        City c2 = new City();
        c2.name = "Kyiv";
        c2.countryName = "Ukraine";
        c2.district = "Kiova";
        c2.population = 2624000;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue14 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue14 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue14 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue14 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue15 ------------------------
     * -getIssue15Test -- test that the sql statement works
     * -getIssue15TestNullN() -- test error handling if N is null
     * -getIssue15TestNullApp() -- test error handling if App instance class null
     * -getIssue15TestNullCountry() -- test error handling if region is null
     * -getIssue15NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue15Test()
    {
        ArrayList<City> cities = issue15.getTopNIssue15("1", app, "Canada");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Ottawa";
        c1.countryName = "Canada";
        c1.district = "Ontario";
        c1.population = 335277;

        cities1.add(c1);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue15 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue15 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue15 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue15 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue16 ------------------------
     * -getIssue16Test -- test that the sql statement works
     * -getIssue16TestNullN() -- test error handling if N is null
     * -getIssue16TestNullApp() -- test error handling if App instance class null
     * -getIssue16TestNullDistrict() -- test error handling if district is null
     * -getIssue16NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue16Test()
    {
        ArrayList<City> cities = issue16.getTopNIssue16("1", app, "Kairo");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Cairo";
        c1.countryName = "Egypt";
        c1.district = "Kairo";
        c1.population = 6789479;

        cities1.add(c1);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue16 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue16 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue16 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue16 4/4 Failed");
        }
    }

    /**
     * ------------------ Tests for Issue 17
     * getIssue17Null() -- test error handling if app is null
     * getIssue17Normal() -- test if the sql statement works
     */
    @Test
    void getIssue17(){
        ArrayList<City> cities1 = issue17.getIssue17(app);
        ArrayList<City> cities2 = new ArrayList<>();

        Objects.equals(cities2, cities1);
    }

    /**
     * ------------------ Tests for Issue 18
     * getIssue18Null() -- test error handling if app is null
     * getIssue18Normal() -- test if the sql statement works
     */
    @Test
    void getIssue18(){
        ArrayList<City> cities1 = issue18.getIssue18(app);
        ArrayList<City> cities2 = new ArrayList<>();

        Objects.equals(cities2, cities1);
    }

    /**
     * -------------------- Tests for Issue19 ------------------------
     * -getIssue19Test -- test that the sql statement works
     * -getIssue19TestNullN() -- test error handling if N is null
     * -getIssue19TestNullApp() -- test error handling if App instance class null
     * -getIssue19NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue19Test()
    {
        ArrayList<City> cities = issue19.getIssue19("1", app);
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Canberra";
        c1.countryName = "Australia";
        c1.district = "Capital Region";
        c1.population = 322723;

        cities1.add(c1);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue15 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue15 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue15 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue15 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue20 ------------------------
     * -getTopNIssue20Test -- test that the sql statement works
     * -getTopNIssue20TestNullN() -- test error handling if N is null
     * -getTopNIssue20TestNullApp() -- test error handling if App instance class null
     * -getTopNIssue20NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue20Test()
    {
        ArrayList<City> cities = issue20.getTopNIssue20("1", app);
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Seoul";
        c1.countryName = "South Korea";
        c1.district = "Seoul";
        c1.population = 9981619;

        cities1.add(c1);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue15 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue15 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue15 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue15 4/4 Failed");
        }
    }

    /**
     * -------------------- Tests for Issue21 ------------------------
     * -getTopNIssue21Test -- test that the sql statement works
     * -getTopNIssue21TestNullN() -- test error handling if N is null
     * -getTopNIssue21TestNullApp() -- test error handling if App instance class null
     * -getTopNIssue21TestNullContinent() -- test error handling if continent instance class null
     * -getTopNIssue21NullAllParams() -- test error handling if all @param null
     */
    @Test
    void getIssue21Test()
    {
        ArrayList<City> cities = issue21.getTopNIssue21("1", app, "Europe");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Moscow";
        c1.countryName = "Russian Federation";
        c1.district = "Moscow (City)";
        c1.population = 8389200;

        cities1.add(c1);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue15 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue15 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue15 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue15 4/4 Failed");
        }
    }

    //Issue22
    @Test
    void getIssue22Test(){
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Baghdad";
        c1.population = 4336000;
        c1.countryName = "Iraq";
        c1.district = "Baghdad";
        cities1.add(c1);

        ArrayList<City> cities = issue22.getTopCapitalsRegion(app, "Middle East", 1);

        ArrayList<City> cities2 = new ArrayList<>();
        for (City city : cities1) {
            for (City c : cities) {
                if (Objects.equals(c.name, city.name)) {
                    City ci = new City();
                    ci.name = c.name;
                    ci.population = c.population;
                    ci.district = c.district;
                    ci.countryName = c.countryName;
                    cities2.add(ci);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue22 1/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue22 1/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue22 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue22 1/4 Failed");
        }

    }
    //Issue23
    @Test
    void getIssue23Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "South America";
        pop.population = 345780000;
        pop.CityPop = 172037859;
        pop.notINCityPop = 173742141;
        pop.inCities = 49.75; //49.75355911254883
        pop.notinCities = 50.25; //50.24644088745117
        pop1.add(pop);

        ArrayList<Population> populations = issue23.getIssue23(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
            assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
            assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
        }
    }

    //Issue24
    @Test
    void getIssue24Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Middle East";
        pop.population = 188380700;
        pop.CityPop = 70371374;
        pop.notINCityPop = 118009326;
        pop.inCities = 37.36; //37.355934143066406
        pop.notinCities = 62.64; //62.644065856933594
        pop1.add(pop);

        ArrayList<Population> populations = issue24.getIssue24(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
            for (int i = 0; i < pop1.size(); i++) {

                assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
                assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
                assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
                assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
                assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
                assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
            }
        }

    //Issue25
    @Test
    void getIssue25Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "United Kingdom";
        pop.population = 59623400;
        pop.CityPop = 22436673;
        pop.notINCityPop = 37186727;
        pop.inCities = 37.63; //37.630645751953125
        pop.notinCities = 62.37; //62.369354248046875
        pop1.add(pop);

        ArrayList<Population> populations = issue25.getIssue25(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
            assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
            assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
        }
    }

    //Issue26
    @Test
    void getIssue26Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Entire world";
        pop.population = 6078749450L;
        pop.CityPop = 1429559884;
        pop.notINCityPop = 4649189566L;
        pop.inCities = 23.52; //23.517335197949308
        pop.notinCities = 76.48; //76.48266480205069
        pop1.add(pop);

        ArrayList<Population> populations = issue26.getIssue26(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
            assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
            assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
        }
    }

    //Issue27
    @Test
    void getIssue27Test(){
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "North America";
        pop.population = 482993000;
        pop1.add(pop);

        ArrayList<Population> populations = issue27.getIssue27(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue27 1/2 Failed (Continent Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue27 2/2 Failed (Population not matching)");

        }
    }



    //Issue28
    @Test
    void getIssue28Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Middle East";
        pop.population = 188380700;
        pop.CityPop = 70371374;
        pop.notINCityPop = 118009326;
        pop.inCities = 37.36; //37.355934143066406
        pop.notinCities = 62.64; //62.644065856933594
        pop1.add(pop);

        ArrayList<Population> populations = issue28.getIssue28(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
            assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
            assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
        }
    }

    //Issue29
    @Test
    void getIssue29Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "United Kingdom";
        pop.population = 59623400;
        pop.CityPop = 22436673;
        pop.notINCityPop = 37186727;
        pop.inCities = 37.63; //37.630645751953125
        pop.notinCities = 62.37; //62.369354248046875
        pop1.add(pop);

        ArrayList<Population> populations = issue29.getIssue29(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
            assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
            assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
        }
    }

    //Issue30
    @Test
    void getIssue30Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Seoul";
        pop.population = 9981619;
        pop.CityPop = 9981619;
        pop.notINCityPop = 0;
        pop.inCities = 100.00;
        pop.notinCities = 0.00;
        pop1.add(pop);

        ArrayList<Population> populations = issue30.getIssue30(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.CityPop = po.CityPop;
                    p.notINCityPop = po.notINCityPop;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue25 1/6 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue25 2/6 Failed (Population not matching)");
            assertEquals(pop1.get(i).CityPop, pop2.get(i).CityPop, "Test getIssue25 3/6 Failed (Population living in cities not matching)");
            assertEquals(pop1.get(i).notINCityPop, pop2.get(i).notINCityPop, "Test getIssue25 4/6 Failed (Population NOT living in cities not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue25 5/6 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue25 6/6 Failed (% not living in cities not matching)");
        }
    }
    //Issue31
    @Test
    void getIssue31Test() {
        ArrayList<City> cities = issue31.getIssue31(app, "Recife");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Recife";
        c1.countryName = "Brazil";
        c1.district = "Pernambuco";
        c1.population = 1378087;

        cities1.add(c1);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue15 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue15 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue15 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue15 4/4 Failed");
        }
    }
    //Issue32
    @Test
    void getIssue32Test() {
        ArrayList<LPopulation> pop1 = new ArrayList<>();
        LPopulation pop = new LPopulation();
        pop.name = "Chinese";
        pop.population = 1968265500;
        pop.pINworld = 32.38; //32.37944771683261
        pop1.add(pop);

        ArrayList<LPopulation> populations = issue32.getIssue32(app);

        ArrayList<LPopulation> pop2 = new ArrayList<>();
        for (LPopulation population : pop1) {
            for (LPopulation po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    LPopulation p = new LPopulation();
                    p.name = po.name;
                    p.population = po.population;
                    p.pINworld = po.pINworld;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue32 1/3 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue32 2/3 Failed (Population not matching)");
            assertEquals(pop1.get(i).pINworld, pop2.get(i).pINworld, "Test getIssue32 3/3 Failed (% in world not matching)");
        }
    }
}
