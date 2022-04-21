package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


public class UnitTests {
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
    static Issue17 issue17;
    static Issue18 issue18;
    static Issue19 issue19;
    static Issue20 issue20;
    static Issue21 issue21;
    static Issue23 issue23;
    static Issue24 issue24;
    static Issue25 issue25;
    static Issue26 issue26;
    static Issue28 issue28;
    static Issue29 issue29;
    static Issue30 issue30;
    static Issue32 issue32;

    @BeforeAll
    static void init()
    {
        app = new App();

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
        issue17 = new Issue17();
        issue18 = new Issue18();
        issue19 = new Issue19();
        issue20 = new Issue20();
        issue21 = new Issue21();
        issue23 = new Issue23();
        issue24 = new Issue24();
        issue25 = new Issue25();
        issue26 = new Issue26();
        issue28 = new Issue28();
        issue29 = new Issue29();
        issue30 = new Issue30();
        issue32 = new Issue32();
    }

    //testing the printCountries method
    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);

    }
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountries(countries);

    }

    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCountriesNormal()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country c = new Country();
        c.code = "NLZ";
        c.name = "New Zealand";
        c.continent = "Oceania";
        c.region = "Australia and New Zealand";
        c.population = 3862000;
        c.capitalName = "Wellington";
        countries.add(c);
        app.printCountries(countries);
    }

    //Testing the printCities method
    @Test
    void printCitiesTestNull()
    {
        app.printCities(null);

    }
    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        app.printCities(cities);

    }

    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> Cities = new ArrayList<>();
        Cities.add(null);
        app.printCities(Cities);
    }

    @Test
    void printCitiesNormal()
    {
        ArrayList<City> Cities = new ArrayList<>();
        City c = new City();
        c.name = "Seoul";
        c.countryName = "South Korea";
        c.district = "Seoul";
        c.population = 3862000;
        Cities.add(c);
        app.printCities(Cities);
    }

    //Testing the printPopulation method
    @Test
    void printPopulationTestNull()
    {
        app.printPopulation(null);

    }
    @Test
    void printPopulationTestEmpty()
    {
        ArrayList<Population> p = new ArrayList<>();
        app.printPopulation(p);

    }

    @Test
    void printPopulationTestContainsNull()
    {
        ArrayList<Population> p = new ArrayList<>();
        p.add(null);
        app.printPopulation(p);
    }

    @Test
    void printPopulationNormal()
    {
        ArrayList<Population> Populations = new ArrayList<>();
        Population p = new Population();
        p.name = "Seoul";
        p.population = 3862000;
        p.inCities = 100;
        p.notinCities = 0;
        Populations.add(p);
        app.printPopulation(Populations);
    }

    //testing the printLPopulation method
    @Test
    void printLPopulationTestNull()
    {
        app.printCountries(null);

    }
    @Test
    void printLPopulationTestEmpty()
    {
        ArrayList<LPopulation> lpop = new ArrayList<>();
        app.printLPopulation(lpop);

    }

    @Test
    void printLPopulationTestContainsNull()
    {
        ArrayList<LPopulation> lpop = new ArrayList<>();
        lpop.add(null);
        app.printLPopulation(lpop);
    }

    @Test
    void printLPopulationNormal()
    {
        ArrayList<LPopulation> lpop = new ArrayList<>();
        LPopulation l = new LPopulation();
        l.name = "Chinese";
        l.population = 1968265500;
        l.pINworld = 32.38;
        lpop.add(l);
        app.printLPopulation(lpop);
    }

    //Issue 6
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

    //Issue 8
    @Test
    void getCitiesLargeSmallPopNullContinent()
    {
        ArrayList<City> cities1 = issue8.getCitiesLargeSmallPop(app, "Europe");

    }

    @Test
    void getCitiesLargeSmallPopNullApp()
    {
        ArrayList<City> cities1 = issue8.getCitiesLargeSmallPop(null, "Europe");

    }

    @Test
    void getCitiesLargeSmallPopNullAllParams()
    {
        ArrayList<City> cities1 = issue8.getCitiesLargeSmallPop(null, null);

    }

    //Issue 9
    @Test
    void getCitiesLargeSmallPopRegionNullRegion()
    {
        ArrayList<City> cities1 = issue9.getCitiesLargeSmallPopRegion(app, null);

    }

    @Test
    void getCitiesLargeSmallPopRegionNullApp()
    {
        ArrayList<City> cities1 = issue9.getCitiesLargeSmallPopRegion(null, "Caribbean");

    }

    @Test
    void getCitiesLargeSmallPopRegionNullAllParams()
    {
        ArrayList<City> cities1 = issue9.getCitiesLargeSmallPopRegion(null, null);

    }

    //Issue 10
    @Test
    void getCitiesLargeSmallPopCountryNullCountry()
    {
        ArrayList<City> cities1 = issue10.getCitiesLargeSmallPopCountry(app, null);

    }

    @Test
    void getCitiesLargeSmallPopCountryNullApp()
    {
        ArrayList<City> cities1 = issue10.getCitiesLargeSmallPopCountry(null, "Japan");

    }

    @Test
    void getCitiesLargeSmallPopCountryNullAllParams()
    {
        ArrayList<City> cities1 = issue10.getCitiesLargeSmallPopCountry(null, null);

    }

    //Issue 11
    @Test
    void getCitiesLargeSmallPopDistrictNullDistrict()
    {
        ArrayList<City> cities1 = issue11.getCitiesLargeSmallPopDistrict(app, null);

    }

    @Test
    void getCitiesLargeSmallPopDistrictNullApp()
    {
        ArrayList<City> cities1 = issue11.getCitiesLargeSmallPopDistrict(null, "Gelderland");

    }

    @Test
    void getCitiesLargeSmallPopDistrictNullAllParams()
    {
        ArrayList<City> cities1 = issue11.getCitiesLargeSmallPopDistrict(null, null);

    }

    //Issue 12
    @Test
    void getIssue12TestNullN() {ArrayList<City> cities1 = issue12.getTopNIssue12(null,app);}
    @Test
    void getIssue12TestNullApp() {ArrayList<City> cities1 = issue12.getTopNIssue12("1",null);}
    @Test
    void getIssue12TestNullAllParam() {ArrayList<City> cities1 = issue12.getTopNIssue12(null,null);}

    //Issue 23
    @Test
    void getIssue23AppNull()
    {
        ArrayList<Population> pop1 = issue23.getIssue23(null);
    }
    @Test
    void getIssue23Normal()
    {
        ArrayList<Population> pop1 = issue23.getIssue23(app);
    }


    //Issue 24
    @Test
    void getIssue24AppNull()
    {
        ArrayList<Population> pop1 = issue24.getIssue24(null);
    }
    @Test
    void getIssue24Normal()
    {
        ArrayList<Population> pop1 = issue24.getIssue24(app);
    }


    //Issue 25
    @Test
    void getIssue25AppNull()
    {
        ArrayList<Population> pop1 = issue25.getIssue25(null);
    }
    @Test
    void getIssue25Normal()
    {
        ArrayList<Population> pop1 = issue25.getIssue25(app);
    }


    //Issue 26
    @Test
    void getIssue26AppNull()
    {
        ArrayList<Population> pop1 = issue26.getIssue26(null);
    }
    @Test
    void getIssue26Normal()
    {
        ArrayList<Population> pop1 = issue26.getIssue26(app);
    }

    //Issue 28
    @Test
    void getIssue28AppNull()
    {
        ArrayList<Population> pop1 = issue28.getIssue28(null, "Middle East");
    }
    @Test
    void getIssue28RegionNull()
    {
        ArrayList<Population> pop1 = issue28.getIssue28(app, null);
    }
    @Test
    void getIssue28AllNull()
    {
        ArrayList<Population> pop1 = issue28.getIssue28(null, null);
    }
    @Test
    void getIssue28Normal()
    {
        ArrayList<Population> pop1 = issue28.getIssue28(app, "Middle East");
    }

    //Issue 29
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
    @Test
    void getIssue29Normal()
    {
        ArrayList<Population> pop1 = issue29.getIssue29(app, "Netherlands");
    }

    //Issue 30
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
    @Test
    void getIssue30Normal()
    {
        ArrayList<Population> pop1 = issue30.getIssue30(app, "Seoul");
    }

    //Issue 32
    @Test
    void getIssue32AppNull()
    {
        ArrayList<LPopulation> pop1 = issue32.getIssue32(null);
    }
    @Test
    void getIssue32Normal()
    {
        ArrayList<LPopulation> pop1 = issue32.getIssue32(app);
    }
}
