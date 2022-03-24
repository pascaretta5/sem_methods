/**
 * Author: Sara
 * Date: 22/02/22
 * Issue 6 tests
 */
package com.napier.sem_group22;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class Test_IntegrationIssue6 {
    static App app;
    static Issue6 issue6;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue6 = new Issue6();
        app.connect("localhost:33060", 30000);
    }


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

}
