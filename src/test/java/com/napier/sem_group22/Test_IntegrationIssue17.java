/**
 * Author: Andrej
 * Date: 22/02/22
 * Issue 17 tests
 */

package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class Test_IntegrationIssue17 {

        static App app;
        static Issue17 issue17;

        @BeforeAll
        static void init()
        {
            app = new App();
            issue17 = new Issue17();
            app.connect("localhost:33060", 30000);
        }

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
    }
