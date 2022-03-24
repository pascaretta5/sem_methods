/**
 * Author: Andrej
 * Date: 22/02/22
 * Issue 19 tests
 */

package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test_IntegrationIssue19 {

    static App app;
    static Issue17 issue19;

    @BeforeAll
    static void init()
    {
        app = new App();
        issue19 = new Issue17();
        app.connect("localhost:33060", 30000);
    }

/*
        @Test
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
        ArrayList<City> city1 = issue19.getIssue17(null);

    }

}
